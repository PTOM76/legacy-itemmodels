package net.pitan76.legacyitemmodels.neoforge.mixin;

import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.pitan76.legacyitemmodels.DummyResourcePack;
import net.pitan76.legacyitemmodels.LegacyItemmodels;
import net.pitan76.legacyitemmodels.TempItems;
import net.pitan76.legacyitemmodels.config.Config;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@Mixin(FileToIdConverter.class)
public class FileToIdConverterMixin {
    @Shadow @Final private String prefix;

    @Inject(method = "fileToId", at = @At("HEAD"))
    private void legacyitemmodels$toResourceId(Identifier path, CallbackInfoReturnable<Identifier> cir) {
        if (!Config.isEnabled()) return;
        if (!Objects.equals(prefix, "items")) return;
        if (path == null) return;
        if (path.getNamespace().equals("minecraft")) return;

        String[] split = path.getPath()
                .substring(0, path.getPath().length() - 5) // .json を削除
                .split("/");

        Identifier id = Identifier.fromNamespaceAndPath(path.getNamespace(), split[split.length - 1]);
        TempItems.items.remove(id);
    }

    @Inject(method = "listMatchingResources", at = @At("RETURN"), cancellable = true)
    private void legacyitemmodels$findResources(ResourceManager resourceManager, CallbackInfoReturnable<Map<Identifier, Resource>> cir) {
        if (!Config.isEnabled()) return;
        if (!Objects.equals(prefix, "items")) return;
        if (TempItems.items.isEmpty()) return;

        Map<Identifier, Resource> map = cir.getReturnValue();
        int count = 0;

        for (Identifier id : TempItems.items) {
            if (id == null) continue;

            Identifier path = Identifier.fromNamespaceAndPath(id.getNamespace(), "items/" + id.getPath() + ".json");
            if (map.containsKey(path)) continue;

            String content = "{\"model\":{\"type\":\"minecraft:model\",\"model\":\"" + id.getNamespace() + ":item/" + id.getPath() + "\"}}";
            InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            Resource resource = new Resource(DummyResourcePack.INSTANCE, () -> stream);
            map.put(path, resource);

            count++;

            //System.out.println("legacyitemmodels: " + "id: " + id.toString() + ", path: " + path.toString());
        }

        LegacyItemmodels.log("Created " + count + " item assets");
        cir.setReturnValue(map);
    }
}
