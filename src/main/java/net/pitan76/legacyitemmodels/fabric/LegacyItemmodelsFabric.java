package net.pitan76.legacyitemmodels.fabric;

import net.fabricmc.api.ModInitializer;
import net.pitan76.legacyitemmodels.LegacyItemmodels;

public class LegacyItemmodelsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LegacyItemmodels.init();
    }
}