package net.voxycommons.commons;

import net.voxycommons.commons.essentials.*;
import net.voxycommons.commons.profileranimations.*;
import net.voxycommons.commons.staff.*;
import net.voxycommons.commons.uteis.*;
import net.voxycommons.commons.curas.*;
import org.bukkit.*;
import net.voxycommons.*;
import net.voxycommons.commons.curas.commands.*;
import net.voxycommons.commons.staff.commands.*;
import net.voxycommons.Schedulers.*;
import net.voxycommons.listerners.*;

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
