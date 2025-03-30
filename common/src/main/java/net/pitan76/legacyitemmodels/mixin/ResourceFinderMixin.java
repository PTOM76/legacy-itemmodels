package net.pitan76.legacyitemmodels.mixin;

import net.minecraft.resource.ResourceFinder;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResourceFinder.class)
public class ResourceFinderMixin {
    @Inject(method = "toResourceId", at = @At("HEAD"))
    private void legacyitemmodels$toResourceId(Identifier path, CallbackInfoReturnable<Identifier> cir) {
        System.out.println("Loading " + path);
    }
}
