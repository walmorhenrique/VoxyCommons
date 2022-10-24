package net.voxycommons.Schedulers;

import org.bukkit.scheduler.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import net.voxycommons.commons.curas.schedulers.*;
import java.util.*;
import net.voxycommons.*;
import org.bukkit.plugin.*;

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
