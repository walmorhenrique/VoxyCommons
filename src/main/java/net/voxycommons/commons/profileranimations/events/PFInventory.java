package net.voxycommons.commons.profileranimations.events;

import org.bukkit.entity.*;
import net.voxycommons.utils.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.inventory.*;
import net.voxycommons.commons.profileranimations.utils.*;
import org.bukkit.event.player.*;

public class PFInventory {

    public static void eventActions(Player p, InventoryClickEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {

            if (!(e.getWhoClicked() instanceof Player) || e.getClickedInventory() == null || p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) return;

            Inventory inv = p.getOpenInventory().getTopInventory();

            if (inv == null || inv.getType() != InventoryType.CRAFTING) return;

            if (e.getRawSlot() == 1) {
                e.setCancelled(true);

            } else if (e.getRawSlot() == 2) {
                e.setCancelled(true);

            } else if (e.getRawSlot() == 3) {
                e.setCancelled(true);

            } else if (e.getRawSlot() == 4) {
                e.setCancelled(true);
            }
        }
    }
    
    public static void eventInvClose(Player p, InventoryCloseEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            if (e.getInventory().getType() != InventoryType.CRAFTING) return;

            if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) return;

            ItemConstructor.removeItems(e.getInventory());
        }
    }
    
    public static void eventInvOpen(Player p, PlayerAchievementAwardedEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) return;

            Inventory inv = p.getOpenInventory().getTopInventory();

            if (inv == null) return;

            if (inv.getType() != InventoryType.CRAFTING) return;

            ItemConstructor.setItems(inv, p);
        }
    }
}
