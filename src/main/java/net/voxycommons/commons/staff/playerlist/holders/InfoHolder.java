package net.voxycommons.commons.staff.playerlist.holders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

@Getter
@AllArgsConstructor
public class InfoHolder implements InventoryHolder {

    private final String player;

    @Override
    public Inventory getInventory() {
        return null;
    }
}
