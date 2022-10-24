package net.voxycommons.commons.staff;

import net.voxycommons.Main;
import net.voxycommons.commons.staff.playerlist.ListInventory;
import net.voxycommons.utils.YmlConfigurator;

public class MainStaff {
    private static ListInventory listInventory;
    
    public static void loadStaff() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema staff habilitado.");
            MainStaff.listInventory = new ListInventory();
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema staff desabilitado.");
        }
    }
    
    public static void unloadStaff() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema staff desabilitado.");
        }
    }
    
    public static ListInventory getListInventory() {
        return MainStaff.listInventory;
    }
}
