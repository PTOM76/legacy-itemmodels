package net.pitan76.legacyitemmodels.config;

import com.google.gson.Gson;
import net.pitan76.legacyitemmodels.PlatformUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    private static final File file = new File(PlatformUtil.getConfigDir().toFile(), "legacyitemmodels.json");

    private static Map<String, Object> map = new HashMap<>();

    private static final Gson gson = new Gson();

    public static boolean init = false;

    public static boolean enabled = true;

    public static void init() {
        if (init) return;
        init = true;

        if (!file.exists()) {
            // Default values
            map.put("enabled", true);
            save();
        }
        load();
    }

    public static boolean isEnabled() {
        if (!init) {
            init();
            enabled = getBoolean("enabled");
        }

        return enabled;
    }


    public static void load() {
        // Load legacyitemmodels.json
        if (!file.exists()) return;

        try (var reader = new FileReader(file)) {
            map = gson.fromJson(reader, map.getClass());
            enabled = getBoolean("enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        // Save compatdatapacks76.json
        try {
            String json = gson.toJson(map);
            if (file.getParentFile().exists() || file.getParentFile().mkdirs())
                file.createNewFile();

            try (var writer = new FileWriter(file)) {
                writer.write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void put(String key, Object value) {
        map.put(key, value);
    }

    public static Object get(String key) {
        return map.get(key);
    }

    public static boolean contains(String key) {
        return map.containsKey(key);
    }

    public static void remove(String key) {
        map.remove(key);
    }

    public static boolean getBoolean(String key) {
        if (!map.containsKey(key)) return true;
        return (boolean) map.get(key);
    }

    public static int getInt(String key) {
        return (int) map.get(key);
    }

    public static double getDouble(String key) {
        return (double) map.get(key);
    }

    public static String getString(String key) {
        return (String) map.get(key);
    }

    public static List<String> getStringList(String key) {
        return (List<String>) map.get(key);
    }
}
