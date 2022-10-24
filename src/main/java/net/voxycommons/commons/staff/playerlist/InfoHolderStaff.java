package net.voxycommons.commons.staff.playerlist;

import org.bukkit.inventory.*;

public class InfoHolderStaff implements InventoryHolder {
    private final String player;
    
    public Inventory getInventory() {
        return null;
    }
    
    public String getPlayer() {
        return this.player;
    }
    
    public InfoHolderStaff(final String player) {
        this.player = player;
    }
}
