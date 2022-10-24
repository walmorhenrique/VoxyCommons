package net.voxycommons.listerners;

import org.bukkit.event.entity.*;
import net.voxycommons.commons.profileranimations.events.*;
import net.voxycommons.commons.curas.events.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import net.voxycommons.commons.essentials.events.*;
import org.bukkit.event.player.*;

public class PlayerE implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();

        ///
        PFPlayer.eventPlayerDeath(e);
        Events.onDeathCuras(p);
        ///
    }
    
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        ///
        Events.onQuitCuras(p);
        ///
    }
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();

        ///
        EssentialsPlayer.eventsOnCommand(p, e);
        ///
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        ///
        Events.onInteractCuras(p, e);
        ///
    }
}
