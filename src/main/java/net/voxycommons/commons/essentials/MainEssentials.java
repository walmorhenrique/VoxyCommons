package net.voxycommons.commons.essentials;

import net.voxycommons.utils.*;
import net.voxycommons.*;

public class MainEssentials {
    public static void loadEssentials() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.esentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema esentials habilitado.");
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema esentials desabilitado.");
        }
    }
    
    public static void unloadEssentials() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.esentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema esentials desabilitado.");
        }
    }
}
