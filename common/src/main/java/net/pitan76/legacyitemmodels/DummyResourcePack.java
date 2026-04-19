package net.pitan76.legacyitemmodels;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

public class DummyResourcePack implements PackResources {

    public static final DummyResourcePack INSTANCE = new DummyResourcePack();

    public static final KnownPack VERSION_ID = new KnownPack(LegacyItemmodels.MOD_ID, "dummy", "1.0.0");
    public static final PackLocationInfo PACK_INFO = new PackLocationInfo(
            LegacyItemmodels.MOD_ID,
            Component.literal(LegacyItemmodels.MOD_NAME),
            PackSource.DEFAULT,
            Optional.of(VERSION_ID)
    );

    @Override
    public @Nullable IoSupplier<InputStream> getRootResource(String... path) {
        return null;
    }

    @Override
    public @Nullable IoSupplier<InputStream> getResource(PackType type, Identifier location) {
        return null;
    }

    @Override
    public void listResources(PackType type, String namespace, String directory, ResourceOutput output) {

    }

    @Override
    public Set<String> getNamespaces(PackType type) {
        return Set.of();
    }

    @Override
    public @Nullable <T> T getMetadataSection(MetadataSectionType<T> metadataSerializer) throws IOException {
        return null;
    }

    @Override
    public PackLocationInfo location() {
        return PACK_INFO;
    }

    @Override
    public void close() {

    }

    @Override
    public String packId() {
        return LegacyItemmodels.MOD_ID;
    }
}
