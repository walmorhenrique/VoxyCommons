package net.voxycommons.commons.profileranimations.events;

import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;

public class PFPlayer {

    public static void eventPlayerDeath(PlayerDeathEvent e) {
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {
            Player p = (Player) e.getEntity();
            Inventory inv = p.getOpenInventory().getTopInventory();
            inv.clear();
        }
    }
}
