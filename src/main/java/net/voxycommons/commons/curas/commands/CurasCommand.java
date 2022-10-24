package net.voxycommons.commons.curas.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.voxycommons.*;
import org.bukkit.*;
import net.voxycommons.utils.*;
import org.bukkit.inventory.*;
import java.util.*;

public class CurasCommand implements CommandExecutor {

    String SemPermissao = YmlConfigurator.CCuras.getString("Mensagens.SemPermissao");
    List<String> CurasAjuda = YmlConfigurator.CCuras.getStringList("Mensagens.ComandosAjuda");
    String ErroItem = YmlConfigurator.CCuras.getString("Mensagens.CuraInexistente");
    String PlayerValid = YmlConfigurator.CCuras.getString("Mensagens.JogadorNaoEcontrado");
    String Gived = YmlConfigurator.CCuras.getString("Mensagens.Enviado");
    
    public boolean onCommand(CommandSender s, Command cmd, String lb, String[] a) {
        if (!(s instanceof Player)) {
            return true;
        }

        Player p = (Player) s;

        if (!YmlConfigurator.Cconfig.getBoolean("commons.curas")) {
            p.sendMessage(Main.Config.getConfig().getString("Mensagens.Comando"));
            return true;
        }

        if (!p.hasPermission("voxycuras.admin")) {
            p.sendMessage(SemPermissao.replace('&', '§'));
            return false;
        }

        if (a.length == 0 || a[0].equalsIgnoreCase("ajuda")) {
            for (String String : CurasAjuda) {
                p.sendMessage(String.replace('&', '§'));
            }
            return true;
        }

        if (a[0].equalsIgnoreCase("reload")) {
            Main.ConfigCuras.reloadConfig();
            p.sendMessage("§cConfiguração recarregada!");
            return true;
        }

        if (!a[0].equalsIgnoreCase("give")) {
            return false;
        }

        if (a.length < 4) {
            for (String String : CurasAjuda) {
                p.sendMessage(String.replace('&', '§'));
            }
            return false;
        }

        Player p2 = Bukkit.getPlayer(a[1]);
        String item = a[2];
        int quantia = Integer.parseInt(a[3]);

        if (p2 == null) {
            p.sendMessage(PlayerValid.replace('&', '§'));
            return false;
        }

        if (YmlConfigurator.CCuras.contains("curas." + item)) {

            List<String> LoreItem = YmlConfigurator.CCuras.getStringList("curas." + item + ".Item.Lore");
            for (int i = 0; i < LoreItem.size(); ++i) {
                LoreItem.set(i, LoreItem.get(i).replace('&', '§'));
            }

            ItemStack item2 = new ItemBuilder(Material.getMaterial(YmlConfigurator.CCuras.getString("curas." + item + ".Item.Material")), 1, (short)YmlConfigurator.CCuras.getInt("curas." + item + ".Item.Data")).setName(YmlConfigurator.CCuras.getString("curas." + item + ".Item.Nome").replace('&', '§')).setSkullOwner(YmlConfigurator.CCuras.getString("curas." + item + ".Item.Skull")).setLore(LoreItem).build();
            p.sendMessage(this.Gived.replace('&', '§').replace("<item>", YmlConfigurator.CCuras.getString("curas." + item + ".Item.Nome").replace('&', '§')).replace("<quantia>", Format.format(quantia)).replace("<nick>", p2.getName()));

            for (int j = 0; j < quantia; ++j) {
                if (p.getInventory().firstEmpty() == -1) {
                    p2.getLocation().getWorld().dropItemNaturally(p2.getLocation(), item2);

                } else {
                    p.getInventory().addItem(item2);
                }
            }
            return false;
        }
        p.sendMessage(this.ErroItem.replace('&', '§'));
        return false;
    }
}
