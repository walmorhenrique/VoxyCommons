package net.voxycommons.commons;

import net.voxycommons.Main;
import net.voxycommons.Schedulers.Scheduler;
import net.voxycommons.commons.curas.MainCuras;
import net.voxycommons.commons.curas.commands.CurasCommand;
import net.voxycommons.commons.essentials.MainEssentials;
import net.voxycommons.commons.profileranimations.MainProfilerAnimations;
import net.voxycommons.commons.staff.MainStaff;
import net.voxycommons.commons.staff.commands.CommandStaff;
import net.voxycommons.commons.uteis.MainUteis;
import net.voxycommons.listerners.InventoryE;
import net.voxycommons.listerners.NaturalE;
import net.voxycommons.listerners.PlayerE;
import net.voxycommons.listerners.RegionE;
import org.bukkit.Bukkit;

public class MainCommons {
    public static void loadCommons() {
        loadEvents();
        MainEssentials.loadEssentials();
        MainProfilerAnimations.loadProfilerAnimations();
        MainStaff.loadStaff();
        MainUteis.loadUteis();
        MainCuras.loadCuras();
        Commands();
        enableSchedulers();
    }
    
    public static void unloadCommons() {
        Bukkit.getScheduler().cancelTasks(Main.getInstance());
        MainEssentials.unloadEssentials();
        MainProfilerAnimations.unloadProfilerAnimations();
        MainStaff.unloadStaff();
        MainUteis.unloadUteis();
        MainCuras.unloadCuras();
    }
    
    public static void Commands() {
        Main.getInstance().getCommand("curas").setExecutor(new CurasCommand());
        Main.getInstance().getCommand("cstaff").setExecutor(new CommandStaff());
    }
    
    public static void enableSchedulers() {
        Scheduler.StartScheduler();
    }
    
    public static void loadEvents() {
        Bukkit.getPluginManager().registerEvents(new InventoryE(), Main.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerE(), Main.getInstance());
        Bukkit.getPluginManager().registerEvents(new NaturalE(), Main.getInstance());
        Bukkit.getPluginManager().registerEvents(new RegionE(), Main.getInstance());
    }
}
