package net.voxycommons.commons;

import net.voxycommons.Main;
import net.voxycommons.listerners.InventoryE;
import net.voxycommons.listerners.PlayerE;
import org.bukkit.Bukkit;

import static net.voxycommons.commons.essentials.MainEssentials.loadEssentials;
import static net.voxycommons.commons.essentials.MainEssentials.unloadEssentials;
import static net.voxycommons.commons.profileranimations.MainProfilerAnimations.loadProfilerAnimations;
import static net.voxycommons.commons.profileranimations.MainProfilerAnimations.unloadProfilerAnimations;
import static net.voxycommons.commons.staff.MainStaff.loadStaff;
import static net.voxycommons.commons.staff.MainStaff.unloadStaff;

public class MainCommons {

    public static void loadCommons(){
        loadEvents();
        loadEssentials();
        loadProfilerAnimations();
        loadStaff();
    }

    public static void unloadCommons(){
        unloadEssentials();
        unloadProfilerAnimations();
        unloadStaff();
    }

    public static void loadEvents(){
        Bukkit.getPluginManager().registerEvents(new InventoryE(), Main.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerE(), Main.getInstance());
    }
}
