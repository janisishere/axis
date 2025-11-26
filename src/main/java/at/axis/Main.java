package at.axis;

import at.axis.api.ConfigAPI;
import at.axis.handlers.CommandHandler;
import at.axis.handlers.GuiHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    ConfigAPI config;
    CommandHandler commandHandler;
    GuiHandler guiHandler;

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        config = new ConfigAPI(this, "config.yml");
        guiHandler = new GuiHandler();
        commandHandler = new CommandHandler(this, guiHandler);

        commandHandler.registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
