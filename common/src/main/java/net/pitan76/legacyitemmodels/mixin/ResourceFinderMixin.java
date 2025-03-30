package net.pitan76.legacyitemmodels.mixin;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceFinder;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.pitan76.legacyitemmodels.DummyResourcePack;
import net.pitan76.legacyitemmodels.TempItems;
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

@Mixin(ResourceFinder.class)
public class ResourceFinderMixin {
    @Shadow @Final private String directoryName;

    @Inject(method = "toResourceId", at = @At("HEAD"))
    private void legacyitemmodels$toResourceId(Identifier path, CallbackInfoReturnable<Identifier> cir) {
        if (!Objects.equals(directoryName, "items")) return;
        if (path.getNamespace().equals("minecraft")) return;

        String[] split = path.getPath()
                .substring(0, path.getPath().length() - 5) // .json を削除
                .split("/");

        Identifier id = Identifier.of(path.getNamespace(), split[split.length - 1]);
        TempItems.items.remove(id);
    }

    @Inject(method = "findResources", at = @At("RETURN"), cancellable = true)
    private void legacyitemmodels$findResources(ResourceManager resourceManager, CallbackInfoReturnable<Map<Identifier, Resource>> cir) {
        if (!Objects.equals(directoryName, "items")) return;

        //System.out.println("legacyitemmodels: ok");

        if (TempItems.items.isEmpty()) return;

        //System.out.println("legacyitemmodels: ok2");

        Map<Identifier, Resource> map = cir.getReturnValue();

        //System.out.println("legacyitemmodels: " + map.keySet().iterator().next().toString());

        for (Identifier id : TempItems.items) {
            Identifier path = Identifier.of(id.getNamespace(), "items/" + id.getPath() + ".json");
            if (map.containsKey(path)) continue;

            String content = "{\"model\":{\"type\":\"minecraft:model\",\"model\":\"" + id.getNamespace() + ":item/" + id.getPath() + "\"}}";
            InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            Resource resource = new Resource(DummyResourcePack.INSTANCE, () -> stream);
            map.put(path, resource);

            System.out.println("legacyitemmodels: " + "id: " + id.toString() + ", path: " + path.toString());
        }
        cir.setReturnValue(map);
    }
}
