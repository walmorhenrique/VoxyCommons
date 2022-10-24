package net.voxycommons.commons.staff.events;

import org.bukkit.event.inventory.*;
import org.bukkit.*;
import net.voxycommons.commons.staff.playerlist.*;
import org.bukkit.entity.*;
import net.voxycommons.utils.*;
import net.voxycommons.commons.staff.*;
import org.bukkit.inventory.*;

public class StaffInventory {

    public static void eventActions(Player p, InventoryClickEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.Modo staff")) {
            ItemStack item = e.getCurrentItem();

            if (e.getInventory().getTitle().equalsIgnoreCase("§8Jogadores ONLINES")) {
                e.setCancelled(true);

                if (e.getSlot() == YmlConfigurator.MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.slot")) {
                    p.openInventory(InventoryConstructor.InvCreate(p, null, p, "Menu_Primario", YmlConfigurator.MStaff));
                    return;
                }

                if (item.getType() == Material.SKULL_ITEM && item.getItemMeta().hasDisplayName()) {
                    String playerName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
                    Player target = Bukkit.getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage(YmlConfigurator.CStaff.getString("Mensagens.Outros.Jogador off ou null").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    p.openInventory(InventoryConstructor.InvCreateInfoHolder(target, target, "Menu_Target", YmlConfigurator.MStaff));
                }
            } else if (e.getInventory().getHolder() instanceof InfoHolderStaff) {
                e.setCancelled(true);
                final InfoHolderStaff infoHolder = (InfoHolderStaff) e.getInventory().getHolder();
                final String playerName2 = infoHolder.getPlayer();
                final Player target2 = Bukkit.getPlayerExact(playerName2);
                if (e.getSlot() == YmlConfigurator.MStaff.getInt("Menus.Menu_Target.itens.invsee.slot")) {
                    if (target2 == p) {
                        p.sendMessage(YmlConfigurator.CStaff.getString("Mensagens.Inventario.Voce nao pode abrir seu proprio inventario").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    p.openInventory(target2.getInventory());

                } else if (e.getSlot() == YmlConfigurator.MStaff.getInt("Menus.Menu_Target.itens.teleport.slot")) {

                    if (p == target2) {
                        p.sendMessage(YmlConfigurator.CStaff.getString("Mensagens.Teleportes.Voce nao pode teleportar a si mesmo").replace("&", "§"));
                        p.closeInventory();

                    } else if (e.getClick().isLeftClick()) {
                        p.closeInventory();
                        p.teleport((Entity) target2);
                        Utils.sendAtionbar(p, YmlConfigurator.CStaff.getString("Mensagens.Teleportes.Actionbar teleportar ate target").replace("&", "§").replace("{target}", target2.getName()));

                    } else if (e.getClick().isRightClick()) {
                        p.closeInventory();
                        target2.teleport((Entity) p);
                        Utils.sendAtionbar(p, YmlConfigurator.CStaff.getString("Mensagens.Teleportes.Actionbar puxar target ate voce").replace("&", "§").replace("{target}", target2.getName()));
                    }

                } else if (e.getSlot() == YmlConfigurator.MStaff.getInt("Menus.Menu_Target.itens.voltar.slot")) {
                    MainStaff.getListInventory().openInventory(p);
                }
            }
        }
    }
}
