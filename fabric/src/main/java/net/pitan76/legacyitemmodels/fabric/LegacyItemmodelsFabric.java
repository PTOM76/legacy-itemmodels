package net.pitan76.legacyitemmodels.fabric;

import net.pitan76.legacyitemmodels.LegacyItemmodels;
import net.fabricmc.api.ModInitializer;

public class LegacyItemmodelsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LegacyItemmodels.init();
    }
}