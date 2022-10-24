package net.voxycommons.listerners;

import org.bukkit.event.player.*;
import org.bukkit.*;
import net.voxycommons.commons.profileranimations.events.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import net.voxycommons.commons.staff.events.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

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
