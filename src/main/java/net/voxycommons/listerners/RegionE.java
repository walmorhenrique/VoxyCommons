package net.voxycommons.listerners;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RegionE implements Listener {

    @EventHandler
    public void onRegionLeave(RegionLeaveEvent e) {
        Player p = e.getPlayer();
    }
    
    @EventHandler
    public void onRegionEnter(RegionEnterEvent e) {
        Player p = e.getPlayer();
    }
}
