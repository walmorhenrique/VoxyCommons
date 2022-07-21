package net.voxycommons.commons.essentials;

import net.voxycommons.Main;
import net.voxycommons.commons.essentials.commands.Gamemode;
import net.voxycommons.utils.YmlConfigurator;

public class MainEssentials {

    public static void loadEssentials(){
        if(YmlConfigurator.Cconfig.getBoolean("Commons.Essentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema Essentials habilitado.");
            Main.getInstance().getCommand("gamemode").setExecutor(new Gamemode());
        } else Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema Essentials desabilitado.");
    }

    public static void unloadEssentials() {
        if(YmlConfigurator.Cconfig.getBoolean("Commons.Essentials")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema Essentials desabilitado.");
        }
    }
}
