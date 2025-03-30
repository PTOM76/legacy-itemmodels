package net.pitan76.legacyitemmodels.mixin;

import net.minecraft.client.item.ItemAssetsLoader;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(ItemAssetsLoader.class)
public abstract class ItemAssetsLoaderMixin {


//    @Inject(method = "load", at = @At("TAIL"))
//    private static void legacyitemmodels$load(ResourceManager resourceManager, Executor executor, CallbackInfoReturnable<CompletableFuture<ItemAssetsLoader.Result>> cir) {
//
//    }

//    @ModifyVariable(method = "load", at = @At("STORE"), ordinal = 0)
//    private static Identifier legacyitemmodels$load(Identifier id) {
//        if (list.contains(id))
//            list.remove(id);
//
//        System.out.println("Loading " + id);
//
//        return id;
//
//    }

}
