package net.pitan76.legacyitemmodels;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TempItems {
    public static final Set<Identifier> items = ConcurrentHashMap.newKeySet();

    static {
        BuiltInRegistries.ITEM.keySet().forEach(id -> {
            if (id == null) return;
            if (id.getNamespace().equals("minecraft")) return;
            items.add(id);
        });
    }
}
