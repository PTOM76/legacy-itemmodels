package net.pitan76.legacyitemmodels;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class TempItems {
    public static List<Identifier> items = new ArrayList<>();

    static {
        Registries.ITEM.getIds().forEach(id -> {
            if (id.getNamespace().equals("minecraft")) return;

            items.add(id);
        });
    }
}
