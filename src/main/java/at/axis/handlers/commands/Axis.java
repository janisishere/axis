package at.axis.handlers.commands;

import at.axis.handlers.GuiHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Axis implements CommandExecutor, TabCompleter {

    private GuiHandler guiHandler;
    public Axis(GuiHandler gui) {
        this.guiHandler = gui;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (command.getName().equalsIgnoreCase("axis")) {
            if (strings.length == 1 && strings[0].equalsIgnoreCase("gui")) {
                if (!(commandSender instanceof Player)) return false;
                guiHandler.showMainUI((Player) commandSender);
            } else {
                if (!(commandSender instanceof Player)) return false;
                guiHandler.showMainUI((Player) commandSender);
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> completions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("axis")) {
            if (strings.length == 1) {
                completions.addAll(Arrays.asList("gui", "config"));
            }
        }
        return completions;
    }
}
