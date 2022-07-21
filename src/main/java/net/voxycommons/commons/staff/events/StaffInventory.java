package net.voxycommons.commons.staff.events;

import net.voxycommons.commons.staff.MainStaff;
import net.voxycommons.commons.staff.playerlist.holders.InfoHolder;
import net.voxycommons.utils.ActionBar;
import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static net.voxycommons.utils.InventoryConstructor.InvCreate;
import static net.voxycommons.utils.InventoryConstructor.InvCreateInfoHolder;
import static net.voxycommons.utils.YmlConfigurator.CStaff;
import static net.voxycommons.utils.YmlConfigurator.MStaff;

public class StaffInventory {

    public static void eventActions(Player p, InventoryClickEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("Commons.Modo staff")) {
            final ItemStack item = e.getCurrentItem();

            //evento ao clicar nos jogadores na pagina inicial
            if (e.getInventory().getTitle().equalsIgnoreCase("§8Jogadores ONLINES")) {
                e.setCancelled(true);

                if (e.getSlot() == MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.slot")) {
                    p.openInventory(InvCreate(p, null, p, "Menu_Primario", MStaff));
                    return;

                } else if (item.getType() != Material.SKULL_ITEM || item.getType() == Material.AIR || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
                    return;

                }
                
                // PEGANDO O PLAYER PELO NOME DA CABEÇA NO INVENTÁRIO
                String playerName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayerExact(playerName);

                if (target == null){
                    p.sendMessage(CStaff.getString("Mensagens.Outros.Jogador off ou null").replace("&", "§"));
                    p.closeInventory();
                    return;
                }

                p.openInventory(InvCreateInfoHolder(target, target, "Menu_Target", MStaff));

                //evento onde mostra o status do jogador clicado
            } else if (e.getInventory().getHolder() instanceof InfoHolder) {
                e.setCancelled(true);

                //pegando target
                final InfoHolder infoHolder = (InfoHolder) e.getInventory().getHolder();
                final String playerName = infoHolder.getPlayer();
                final Player target = Bukkit.getPlayerExact(playerName);

                if (e.getSlot() == MStaff.getInt("Menus.Menu_Target.itens.invsee.slot")) {

                    if (target == p) {
                        p.sendMessage(CStaff.getString("Mensagens.Inventario.Voce nao pode abrir seu proprio inventario").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }

                    p.openInventory(target.getInventory());

                } else if (e.getSlot() == MStaff.getInt("Menus.Menu_Target.itens.teleport.slot")) {

                    if (p == target) {
                        p.sendMessage(CStaff.getString("Mensagens.Teleportes.Voce nao pode teleportar a si mesmo").replace("&", "§"));
                        p.closeInventory();

                    } else if (e.getClick().isLeftClick()) {
                        p.closeInventory();
                        p.teleport(target);
                        ActionBar.send(p, CStaff.getString("Mensagens.Teleportes.Actionbar teleportar ate target").replace("&", "§").replace("{target}", target.getName()));

                    } else if (e.getClick().isRightClick()) {
                        p.closeInventory();
                        target.teleport(p);
                        ActionBar.send(p, CStaff.getString("Mensagens.Teleportes.Actionbar puxar target ate voce").replace("&", "§").replace("{target}", target.getName()));
                    }

                } else if (e.getSlot() == MStaff.getInt("Menus.Menu_Target.itens.voltar.slot")) {
                    MainStaff.getListInventory().openInventory(p);
                }
            }
        }
    }
}
