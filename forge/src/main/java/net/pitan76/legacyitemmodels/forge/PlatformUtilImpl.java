package net.pitan76.legacyitemmodels.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class PlatformUtilImpl {
    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }
}
