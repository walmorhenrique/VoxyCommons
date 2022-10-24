package net.voxycommons.listerners;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import com.mewin.WGRegionEvents.events.*;

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
