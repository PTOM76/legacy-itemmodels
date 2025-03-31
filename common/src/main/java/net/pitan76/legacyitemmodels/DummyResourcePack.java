package net.pitan76.legacyitemmodels;

import net.minecraft.registry.VersionedIdentifier;
import net.minecraft.resource.*;
import net.minecraft.resource.metadata.ResourceMetadataSerializer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

public class DummyResourcePack implements ResourcePack {

    public static final DummyResourcePack INSTANCE = new DummyResourcePack();

    public static final VersionedIdentifier VERSION_ID = new VersionedIdentifier(LegacyItemmodels.MOD_ID, "dummy", "1.0.0");
    public static final ResourcePackInfo PACK_INFO = new ResourcePackInfo(
            LegacyItemmodels.MOD_ID,
            Text.literal(LegacyItemmodels.MOD_NAME),
            ResourcePackSource.NONE,
            Optional.of(VERSION_ID)
    );

    @Override
    public @Nullable InputSupplier<InputStream> openRoot(String... segments) {
        return null;
    }

    @Override
    public @Nullable InputSupplier<InputStream> open(ResourceType type, Identifier id) {
        return null;
    }

    @Override
    public void findResources(ResourceType type, String namespace, String prefix, ResultConsumer consumer) {

    }

    @Override
    public Set<String> getNamespaces(ResourceType type) {
        return Set.of();
    }

    @Override
    public @Nullable <T> T parseMetadata(ResourceMetadataSerializer<T> metadataSerializer) throws IOException {
        return null;
    }

    @Override
    public ResourcePackInfo getInfo() {
        return PACK_INFO;
    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return LegacyItemmodels.MOD_ID;
    }
}
