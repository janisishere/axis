package at.axis.api;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class configAPI {
    private final JavaPlugin plugin;
    private final String fileName;
    private File configFile;
    private FileConfiguration config;

    public configAPI(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
    }

    public void load() {
        configFile = new File(plugin.getDataFolder(), fileName);

        // Create plugin folder if it doesn't exist
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        // Create default file if not present
        if (!configFile.exists()) {
            plugin.saveResource(fileName, false);
        }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        load();
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public Object get(String path) {
        return config.get(path); // assuming you have a FileConfiguration named "config"
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public void set(String path, Object value) {
        Object old = config.get(path);
        config.set(path, value);

        Runnable fire = () -> Bukkit.getPluginManager()
                .callEvent(new at.axis.apiDepends.ConfigAPIChangeEvent(path, old, value));

        if (Bukkit.isPrimaryThread()) {
            fire.run();
        } else {
            Bukkit.getScheduler().runTask(plugin, fire);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
