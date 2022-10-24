package net.voxycommons.listerners;

import org.bukkit.event.weather.*;
import net.voxycommons.utils.*;
import org.bukkit.event.*;

public class NaturalE implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(YmlConfigurator.CEssentials.getBoolean("Sistemas.Desativar chuva"));
        }
    }
}
