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
import org.bukkit.inventory.Inventory;

public class InventoryE implements Listener {

    @EventHandler
    public void onInventoryOpen(PlayerAchievementAwardedEvent e) {
        if(e.getAchievement().equals(Achievement.OPEN_INVENTORY)) {
            e.setCancelled(true);

            Player p = e.getPlayer();

            //Classes Events

            PFInventory.eventInvOpen(p, e);

            //Classes Events

        } else {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();

        //Classes Events

        PFInventory.eventActions(p, e);
        StaffInventory.eventActions(p, e);

        //Classes Events
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        Inventory i = e.getInventory();
        Player p = (Player) e.getPlayer();

        //Classes Events

        PFInventory.eventInvClose(p, e);

        //Classes Events
    }
}
