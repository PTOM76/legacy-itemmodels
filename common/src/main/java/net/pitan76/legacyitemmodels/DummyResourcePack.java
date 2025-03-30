package net.pitan76.legacyitemmodels;

import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourcePackInfo;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.metadata.ResourceMetadataSerializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class DummyResourcePack implements ResourcePack {

    public static final DummyResourcePack INSTANCE = new DummyResourcePack();

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
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return LegacyItemmodels.MOD_ID;
    }
}
