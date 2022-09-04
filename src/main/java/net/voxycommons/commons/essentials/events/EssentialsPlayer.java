package net.voxycommons.commons.essentials.events;

import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static net.voxycommons.utils.YmlConfigurator.CEssentials;

public class EssentialsPlayer {

    public static void eventsOnCommand(Player p, PlayerCommandPreprocessEvent e) {
        if (YmlConfigurator.Cconfig.getBoolean("Commons.Essentials")) {
            String s = e.getMessage().toLowerCase();

            if (!CEssentials.getStringList("Utils.Comandos liberados").contains(s.split(" ")[0])) e.setCancelled(true);
        }
    }
}
