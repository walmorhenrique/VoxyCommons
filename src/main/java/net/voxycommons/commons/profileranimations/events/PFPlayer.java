package net.voxycommons.commons.profileranimations.events;

import org.bukkit.event.entity.*;
import net.voxycommons.utils.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class PFPlayer {

    public static void eventPlayerDeath(PlayerDeathEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            Player p = e.getEntity();
            Inventory inv = p.getOpenInventory().getTopInventory();
            inv.clear();
        }
    }
}
