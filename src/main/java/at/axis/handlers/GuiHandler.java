package at.axis.handlers;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GuiHandler implements Listener {

    public void configUI(Player target) {
        Gui gui = Gui.gui()
                .title(Component.text("Axis Menu / Config"))
                .rows(6)
                .create();

        gui.getFiller().fill(
                ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE)
                        .name(Component.text(""))
                        .asGuiItem()
        );

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        gui.open(target);
    }

    public void showMainUI(Player target) {
        Gui gui = Gui.gui()
                .title(Component.text("Axis Menu"))
                .rows(6)
                .create();

        gui.getFiller().fill(
                ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE)
                    .name(Component.text(""))
                    .asGuiItem()
        );

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        GuiItem close = ItemBuilder.from(Material.BARRIER)
                .name(
                        Component.text("-")
                                .color(TextColor.color(0xBC2525))
                                .decoration(TextDecoration.OBFUSCATED, true)
                                .decoration(TextDecoration.ITALIC, false)
                                .decoration(TextDecoration.BOLD, false)
                                .append(
                                        Component.text(" Close ")
                                                .color(TextColor.color(0xBC2525))
                                                .decoration(TextDecoration.BOLD, true)
                                                .decoration(TextDecoration.ITALIC, false)
                                                .decoration(TextDecoration.OBFUSCATED, false),
                                        Component.text("-")
                                                .color(TextColor.color(0xBC2525))
                                                .decoration(TextDecoration.OBFUSCATED, true)
                                                .decoration(TextDecoration.ITALIC, false)
                                                .decoration(TextDecoration.BOLD, false)
                                )
                )
                .lore(Component.text("Close GUI").color(TextColor.color(0xffffff)).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true))
                .asGuiItem(event -> {
            gui.close(target);
        });

        GuiItem config = ItemBuilder.from(Material.WRITABLE_BOOK)
                .name(
                        Component.text("-")
                                .color(TextColor.color(0xF24D4D))
                                .decoration(TextDecoration.OBFUSCATED, true)
                                .decoration(TextDecoration.ITALIC, false)
                                .decoration(TextDecoration.BOLD, false)
                                .append(
                                        Component.text(" Config ")
                                                .color(TextColor.color(0xF24D4D))
                                                .decoration(TextDecoration.BOLD, true)
                                                .decoration(TextDecoration.ITALIC, false)
                                                .decoration(TextDecoration.OBFUSCATED, false),
                                        Component.text("-")
                                                .color(TextColor.color(0xF24D4D))
                                                .decoration(TextDecoration.OBFUSCATED, true)
                                                .decoration(TextDecoration.ITALIC, false)
                                                .decoration(TextDecoration.BOLD, false)
                                )
                )
                .lore(Component.text("Configurate Axis").color(TextColor.color(0xffffff)).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true))
                .asGuiItem(event -> {
                    gui.close(target);
                    configUI(target);
                }
        );

        GuiItem players = ItemBuilder.from(Material.PLAYER_HEAD)
                .name(
                        Component.text("-")
                                .color(TextColor.color(0x9852C1))
                                .decoration(TextDecoration.OBFUSCATED, true)
                                .decoration(TextDecoration.ITALIC, false)
                                .decoration(TextDecoration.BOLD, false)
                                .append(
                                        Component.text(" Players ")
                                            .color(TextColor.color(0x9852C1))
                                            .decoration(TextDecoration.BOLD, true)
                                                .decoration(TextDecoration.ITALIC, false)
                                            .decoration(TextDecoration.OBFUSCATED, false),
                                        Component.text("-")
                                                .color(TextColor.color(0x9852C1))
                                                .decoration(TextDecoration.OBFUSCATED, true)
                                                .decoration(TextDecoration.BOLD, false)
                                                .decoration(TextDecoration.ITALIC, false)
                                )
                )
                .lore(Component.text("Manage all Online Players").color(TextColor.color(0xffffff)).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true))
                .asGuiItem(event -> {

        });

        gui.setItem(6, 5, close);
        gui.setItem(3, 3, config);
        gui.setItem(3, 5, players);

        gui.open(target);
    }

}
