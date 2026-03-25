package net.pitan76.legacyitemmodels;

import net.pitan76.legacyitemmodels.config.Config;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LegacyItemmodels {
	public static final String MOD_ID = "legacyitemmodels";
	public static final String MOD_NAME = "Legacy Itemmodels";

	public static void init() {
		Config.init();
	}

	public static Logger LOGGER = LogManager.getLogger();

	public static void log(Level level, String message){
		LOGGER.log(level, "[" + MOD_NAME + "] " + message);
	}

	public static void log(String message){
		log(Level.INFO, message);
	}
}
