package net.voxycommons.commons.essentials.events;

import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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
