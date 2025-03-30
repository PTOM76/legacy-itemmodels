package net.pitan76.legacyitemmodels.forge;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.pitan76.legacyitemmodels.LegacyItemmodels;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LegacyItemmodels.MOD_ID)
public class LegacyItemmodelsForge {
    public LegacyItemmodelsForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);
    }

    public void onSetup(FMLCommonSetupEvent e) {
        LegacyItemmodels.init();
    }
}