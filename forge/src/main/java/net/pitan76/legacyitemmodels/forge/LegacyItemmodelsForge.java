package net.pitan76.legacyitemmodels.forge;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.pitan76.legacyitemmodels.LegacyItemmodels;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LegacyItemmodels.MOD_ID)
public class LegacyItemmodelsForge {
    public LegacyItemmodelsForge(FMLJavaModLoadingContext context) {
        BusGroup busGroup = context.getModBusGroup();
        FMLCommonSetupEvent.getBus(busGroup).addListener(this::onSetup);
    }

    public void onSetup(FMLCommonSetupEvent e) {
        LegacyItemmodels.init();
    }
}