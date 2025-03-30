package net.pitan76.legacyitemmodels;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LegacyItemmodels {
	public static final String MOD_ID = "compatdatapacks76";
	public static final String MOD_NAME = "Compat Datapacks";


	public static List<Identifier> items = new ArrayList<>();

	static {
		Registries.ITEM.getIds().forEach(id -> {
			if (!id.getNamespace().equals("minecraft"))
				items.add(id);
		});
	}

	public static void init() {
	}

	public static Logger LOGGER = LogManager.getLogger();

	public static void log(Level level, String message){
		LOGGER.log(level, "[" + MOD_NAME + "] " + message);
	}

	public static void log(String message){
		log(Level.INFO, message);
	}
}
