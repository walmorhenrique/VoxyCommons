package net.voxycommons.commons.curas;

import java.util.*;
import net.voxycommons.utils.*;
import net.voxycommons.*;

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
