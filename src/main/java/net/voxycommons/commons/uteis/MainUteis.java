package net.voxycommons.commons.uteis;

import net.voxycommons.utils.*;
import net.voxycommons.*;

public class MainUteis
{
    public static void loadUteis() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.uteis")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§a Sistema uteis habilitado.");
        }
        else {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema uteis desabilitado.");
        }
    }
    
    public static void unloadUteis() {
        if (YmlConfigurator.Cconfig.getBoolean("commons.uteis")) {
            Main.getInstance().getServer().getConsoleSender().sendMessage("§7[VoxyCommons]§c Sistema uteis desabilitado.");
        }
    }
}
