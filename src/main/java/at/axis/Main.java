package at.axis;

import at.axis.api.ConfigAPI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    ConfigAPI config;

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        config = new ConfigAPI(this, "config.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
