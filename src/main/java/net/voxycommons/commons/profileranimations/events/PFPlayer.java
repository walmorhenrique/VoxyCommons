package net.voxycommons.commons.profileranimations.events;

import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;

public class PFPlayer {

    public static void eventPlayerDeath(PlayerDeathEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            Player p = e.getEntity();
            Inventory inv = p.getOpenInventory().getTopInventory();
            inv.clear();
        }
    }
}
