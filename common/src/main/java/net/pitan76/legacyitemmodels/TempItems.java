package net.pitan76.legacyitemmodels;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TempItems {
    public static final Set<Identifier> items = ConcurrentHashMap.newKeySet();

    static {
        Registries.ITEM.getIds().forEach(id -> {
            if (id == null) return;
            if (id.getNamespace().equals("minecraft")) return;

            items.add(id);
        });
    }
}
