package net.voxycommons.commons.staff.commands;

import net.voxycommons.Main;
import net.voxycommons.commons.staff.MainStaff;
import net.voxycommons.utils.Utils;
import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStaff implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command c, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cEsse comando é apenas para jogadores!");
            return false;
        }

        Player p = (Player)sender;

        if (!YmlConfigurator.Cconfig.getBoolean("commons.modo staff")) {
            p.sendMessage(Main.Config.get().getString("Mensagens.Comando"));
            return true;
        }

        if (args.length > 0) {
            p.sendMessage("§cComando inválido, use: /" + c.getName());
            p.playSound(p.getLocation(), Sound.valueOf(YmlConfigurator.CStaff.getString("Sounds.sound error")), 1.0f, 1.0f);
            return false;
        }

        if (p.hasPermission(YmlConfigurator.CStaff.getString("Permissions.use"))) {
            MainStaff.getListInventory().openInventory(p);
            p.playSound(p.getLocation(), Sound.valueOf(YmlConfigurator.CStaff.getString("Sounds.open menu")), 1.0f, 1.0f);

        } else {
            Utils.sendAtionbar(p, YmlConfigurator.CStaff.getString("Permissions.message sem perm").replace("&", "§"));
            p.playSound(p.getLocation(), Sound.valueOf(YmlConfigurator.CStaff.getString("Sounds.sound error")), 1.0f, 1.0f);
        }
        return false;
    }
}
