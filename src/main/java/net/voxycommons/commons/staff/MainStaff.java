package net.voxycommons.commons.staff;

import net.voxycommons.commons.staff.playerlist.*;
import net.voxycommons.utils.*;
import net.voxycommons.*;

public class MainStaff {
    private static ListInventory listInventory;
    
    public static void loadStaff() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.Modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema staff habilitado.");
            MainStaff.listInventory = new ListInventory();
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema staff desabilitado.");
        }
    }
    
    public static void unloadStaff() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.Modo staff")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema staff desabilitado.");
        }
    }
    
    public static ListInventory getListInventory() {
        return MainStaff.listInventory;
    }
}
