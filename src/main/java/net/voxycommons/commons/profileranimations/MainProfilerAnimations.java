package net.voxycommons.commons.profileranimations;

import net.voxycommons.Main;
import net.voxycommons.utils.YmlConfigurator;

public class MainProfilerAnimations {

    public static void loadProfilerAnimations(){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema ProfilerAnimations habilitado.");
        } else Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema ProfilerAnimations desabilitado.");
    }

    public static void unloadProfilerAnimations() {
        if(YmlConfigurator.Cconfig.getBoolean("Commons.ProfilerAnimations")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema ProfilerAnimations desabilitado.");
        }
    }
}
