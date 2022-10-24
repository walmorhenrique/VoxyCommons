package net.voxycommons.commons.essentials.events;

import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import net.voxycommons.utils.*;

public class EssentialsPlayer
{
    public static void eventsOnCommand(Player p, PlayerCommandPreprocessEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("commons.esentials") && YmlConfigurator.CEssentials.getBoolean("Sistemas.Usar sistema de comandos")) {
            String s = e.getMessage().toLowerCase();

            if (p.hasPermission("*")) return;

            if (!YmlConfigurator.CEssentials.getStringList("Sistemas.Comandos liberados").contains(s.split("")[0])) {
                p.sendMessage(YmlConfigurator.CEssentials.getString("Sistemas.Mensagem de erro"));
                e.setCancelled(true);
            }
        }
    }
}
