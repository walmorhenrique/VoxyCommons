package net.voxycommons.commons.essentials;

import net.voxycommons.Main;
import net.voxycommons.utils.YmlConfigurator;

public class MainEssentials {
    public static void loadEssentials() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.essentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema essentials habilitado.");
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema esentials desabilitado.");
        }
    }
    
    public static void unloadEssentials() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.essentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema essentials desabilitado.");
        }
    }
}
