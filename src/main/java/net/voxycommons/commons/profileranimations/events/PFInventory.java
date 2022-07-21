package net.voxycommons.commons.profileranimations.events;

import net.voxycommons.commons.profileranimations.utils.ItemConstructor;
import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.inventory.Inventory;

public class PFInventory {

    public static void eventActions(Player p, InventoryClickEvent e){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {

            if(!(e.getWhoClicked() instanceof Player) || e.getClickedInventory() == null || p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR)
                return;

            Inventory inv = p.getOpenInventory().getTopInventory();

            if(inv == null || inv.getType() != InventoryType.CRAFTING) return;

            if(e.getRawSlot() == 1) {
                e.setCancelled(true);

                //escrever evento


            } else if(e.getRawSlot() == 2) {
                e.setCancelled(true);

                //escrever evento


            } else if(e.getRawSlot() == 3) {
                e.setCancelled(true);

                //escrever evento


            } else if(e.getRawSlot() == 4) {
                e.setCancelled(true);

                //escrever evento

            }
        }
    }

    public static void eventInvClose(Player p, InventoryCloseEvent e){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {

            if(e.getInventory().getType() != InventoryType.CRAFTING)
                return;

            if(p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR)
                return;

            ItemConstructor.removeItems(e.getInventory());
        }
    }

    public static void eventInvOpen(Player p, PlayerAchievementAwardedEvent e){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {

            if(p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) {
                return;
            }

            Inventory inv = p.getOpenInventory().getTopInventory();

            if(inv == null) {
                return;
            }

            if(inv.getType() != InventoryType.CRAFTING) {
                return;
            }

            ItemConstructor.setItems(inv, p);
        }
    }
}
