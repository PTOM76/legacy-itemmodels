package net.pitan76.legacyitemmodels.mixin;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceFinder;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.pitan76.legacyitemmodels.DummyResourcePack;
import net.pitan76.legacyitemmodels.LegacyItemmodels;
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

        String[] split = path.getPath().replace(".json", "").split("/");
        Identifier id = Identifier.of(path.getNamespace(), split[split.length - 1]);
        LegacyItemmodels.items.remove(id);
    }

    @Inject(method = "findResources", at = @At("RETURN"))
    private void legacyitemmodels$findResources(ResourceManager resourceManager, CallbackInfoReturnable<Map<Identifier, Resource>> cir) {
        if (!Objects.equals(directoryName, "items")) return;
        if (LegacyItemmodels.items.isEmpty()) return;

        Map<Identifier, Resource> map = cir.getReturnValue();
        for (Identifier id : LegacyItemmodels.items) {
            String content = "{ \"model\": { \"type\": \"minecraft:model\", \"model\": \"" + id.getNamespace() + ":item/" + id.getPath() + "\" } }";
            InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            Resource resource = new Resource(DummyResourcePack.INSTANCE, () -> stream);
            map.put(id, resource);
        }
        cir.setReturnValue(map);
    }
}
