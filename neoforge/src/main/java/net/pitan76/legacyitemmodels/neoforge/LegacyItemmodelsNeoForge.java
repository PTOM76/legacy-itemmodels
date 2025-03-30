package net.pitan76.legacyitemmodels.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.pitan76.legacyitemmodels.LegacyItemmodels;

@Mod(LegacyItemmodels.MOD_ID)
public class LegacyItemmodelsNeoForge {
    public LegacyItemmodelsNeoForge(ModContainer modContainer) {
        LegacyItemmodels.init();
    }
}