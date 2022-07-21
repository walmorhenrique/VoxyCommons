package net.voxycommons.utils;

import net.voxycommons.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class YmlConfigurator {

    public static FileConfiguration Cconfig = Main.Config.getConfig();
    public static FileConfiguration CStaff = Main.ConfigStaff.getConfig();
    public static FileConfiguration MStaff = Main.MenusStaff.getConfig();
    public static FileConfiguration CProfilerAnimations = Main.ConfigProfilerAnimations.getConfig();
    public static FileConfiguration MProfilerAnimations = Main.MenusProfilerAnimations.getConfig();
    public static FileConfiguration CEssentials = Main.ConfigEssentials.getConfig();
}
