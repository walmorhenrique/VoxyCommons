package net.voxycommons.listerners;

import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NaturalE implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(YmlConfigurator.CEssentials.getBoolean("Sistemas.Desativar chuva"));
        }
    }
}
