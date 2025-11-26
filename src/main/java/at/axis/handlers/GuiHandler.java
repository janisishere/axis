package at.axis.handlers;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GuiHandler implements Listener {

    public void showMainUI(Player target) {
        Gui gui = Gui.gui()
                .title(Component.text("Axis Menu"))
                .rows(6)
                .create();

        gui.getFiller().fill(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).asGuiItem());

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        gui.open(target);
    }

}
