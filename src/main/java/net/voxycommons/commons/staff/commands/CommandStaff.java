package net.voxycommons.commons.staff.commands;

import net.voxycommons.commons.staff.MainStaff;
import net.voxycommons.utils.ActionBar;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.voxycommons.utils.InventoryConstructor.InvCreate;
import static net.voxycommons.utils.YmlConfigurator.CStaff;

public class CommandStaff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command c, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cEsse comando é apenas para jogadores!");
            return false;
        }

        Player p = (Player) sender;

        if(args.length > 0) {
            p.sendMessage("§cComando inválido, use: /" + c.getName());
            p.playSound(p.getLocation(), Sound.valueOf(CStaff.getString("Sounds.sound error")), 1f, 1f);
            return false;
        }

        if(p.hasPermission(CStaff.getString("Permissions.use"))) {
            //p.openInventory(InvCreate(p, null, null, "Menu_Primario", CStaff));
            MainStaff.getListInventory().openInventory(p);
            p.playSound(p.getLocation(), Sound.valueOf(CStaff.getString("Sounds.open menu")), 1f, 1f);

        } else {
            ActionBar.send(p, CStaff.getString("Permissions.message sem perm").replace("&", "§"));
            p.playSound(p.getLocation(), Sound.valueOf(CStaff.getString("Sounds.sound error")), 1f, 1f);
        }
        return false;
    }
}
