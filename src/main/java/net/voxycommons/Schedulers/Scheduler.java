package net.voxycommons.Schedulers;

import net.voxycommons.Main;
import net.voxycommons.commons.curas.schedulers.Schedulers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scheduler
{
    public static void StartScheduler() {
        new BukkitRunnable() {
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Schedulers.SchedulerCuras(p);
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 20L);
    }
}
