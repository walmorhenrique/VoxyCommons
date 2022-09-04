package net.voxycommons.listerners;

import net.voxycommons.commons.essentials.events.EssentialsPlayer;
import net.voxycommons.commons.profileranimations.events.PFPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerE implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        //Classes Events

        PFPlayer.eventPlayerDeath(e);

        //Classes Events
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();

        //Classes Events

        //Classes Events
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();

        //Classes Events

        EssentialsPlayer.eventsOnCommand(p, e);

        //Classes Events
    }

}
