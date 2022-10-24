package net.voxycommons.utils;

import org.bukkit.configuration.file.*;
import net.voxycommons.*;

public class YmlConfigurator {

    public static FileConfiguration Cconfig = Main.Config.get();
    public static FileConfiguration CStaff = Main.ConfigStaff.get();
    public static FileConfiguration CCuras = Main.ConfigCuras.get();
    public static FileConfiguration MStaff = Main.MenusStaff.get();
    public static FileConfiguration CProfilerAnimations = Main.ConfigProfilerAnimations.get();
    public static FileConfiguration MProfilerAnimations = Main.MenusProfilerAnimations.get();
    public static FileConfiguration CEssentials = Main.ConfigEssentials.get();

}
