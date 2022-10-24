package net.voxycommons.commons.curas;

import net.voxycommons.Main;
import net.voxycommons.utils.YmlConfigurator;

import java.util.HashMap;

public class MainCuras {
    public static HashMap<String, Double> CurasDelayUse = new HashMap<>();
    public static HashMap<String, String> UseCura = new HashMap<>();
    
    public static void loadCuras() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.curas")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema curas habilitado.");
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema curas desabilitado.");
        }
    }
    
    public static void unloadCuras() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.curas")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema curas desabilitado.");
        }
    }
}
