package net.voxycommons.commons.staff;

import lombok.Getter;
import net.voxycommons.Main;
import net.voxycommons.commons.staff.commands.CommandStaff;
import net.voxycommons.commons.staff.playerlist.ListInventory;
import net.voxycommons.utils.YmlConfigurator;

public class MainStaff {

    @Getter
    private static ListInventory listInventory;

    public static void loadStaff(){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.Modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema Staff habilitado.");
            listInventory = new ListInventory();

            //
            Main.getInstance().getCommand("cstaff").setExecutor(new CommandStaff());
        } else Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema Staff desabilitado.");
    }

    public static void unloadStaff() {
        if(YmlConfigurator.Cconfig.getBoolean("Commons.Modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema Staff desabilitado.");
        }
    }
}