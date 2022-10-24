package net.voxycommons.commons.profileranimations;

import net.voxycommons.Main;
import net.voxycommons.utils.YmlConfigurator;

public class MainProfilerAnimations {
    public static void loadProfilerAnimations() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema profileranimations habilitado.");
        } else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema profileranimations desabilitado.");
        }
    }
    
    public static void unloadProfilerAnimations() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.profileranimations")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema profileranimations desabilitado.");
        }
    }
}
