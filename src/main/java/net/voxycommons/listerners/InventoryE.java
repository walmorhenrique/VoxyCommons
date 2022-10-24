package net.voxycommons.listerners;

import net.voxycommons.commons.profileranimations.events.PFInventory;
import net.voxycommons.commons.staff.events.StaffInventory;
import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class InventoryE implements Listener {
    @EventHandler
    public void onInventoryOpen(PlayerAchievementAwardedEvent e) {
        if (e.getAchievement().equals(Achievement.OPEN_INVENTORY)) {
            e.setCancelled(true);
            Player p = e.getPlayer();

            ///
            PFInventory.eventInvOpen(p, e);
            ///

        } else {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;

        Player p = (Player)e.getWhoClicked();

        ///
        PFInventory.eventActions(p, e);
        StaffInventory.eventActions(p, e);
        ///
    }
    
    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        Player p = (Player)e.getPlayer();

        ///
        PFInventory.eventInvClose(p, e);
        ///
    }
}
