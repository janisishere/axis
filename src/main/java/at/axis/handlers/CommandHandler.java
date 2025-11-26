package at.axis.handlers;

import at.axis.handlers.commands.Axis;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CommandHandler {

    private final JavaPlugin plugin;
    private final GuiHandler guiHandler;

    public CommandHandler(JavaPlugin plugin, GuiHandler gui) {
        this.plugin = plugin;
        this.guiHandler = gui;
    }

    private void register(String name, Object obj) {
        PluginCommand cmd = Objects.requireNonNull(plugin.getCommand(name));

        if (obj instanceof CommandExecutor executor) {
            cmd.setExecutor(executor);
        }

        if (obj instanceof TabCompleter completer) {
            cmd.setTabCompleter(completer);
        }
    }

    public void registerCommands() {
        register("axis", new Axis(guiHandler));
    }

}
