package net.voxycommons.listerners;

import net.voxycommons.commons.curas.events.Events;
import net.voxycommons.commons.essentials.events.EssentialsPlayer;
import net.voxycommons.commons.profileranimations.events.PFPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
