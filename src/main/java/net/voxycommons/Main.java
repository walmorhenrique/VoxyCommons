package net.voxycommons;

import org.bukkit.plugin.java.*;
import net.voxycommons.utils.*;
import net.voxycommons.commons.*;
import com.henryfabio.minecraft.inventoryapi.manager.*;

public final class Main extends JavaPlugin {

    public static YmlConfigConstructor Config;
    public static YmlConfigConstructor ConfigEssentials;
    public static YmlConfigConstructor ConfigCuras;
    public static YmlConfigConstructor ConfigUteis;
    public static YmlConfigConstructor ConfigStaff;
    public static YmlConfigConstructor MenusStaff;
    public static YmlConfigConstructor ConfigProfilerAnimations;
    public static YmlConfigConstructor MenusProfilerAnimations;

    public static Main getInstance() {
        return getPlugin(Main.class);
    }

    public void onEnable() {
        onLoadConfig();
        MainCommons.loadCommons();
        InventoryManager.enable(this);
    }

    public void onDisable() {
        MainCommons.unloadCommons();
    }

    public void onLoadConfig() {
        (Config = new YmlConfigConstructor(this, "config.yml")).saveDefaultConfig();
        (ConfigEssentials = new YmlConfigConstructor(this, "commons/esentials/config.yml")).saveDefaultConfig();
        (ConfigCuras = new YmlConfigConstructor(this, "commons/curas/config.yml")).saveDefaultConfig();
        (ConfigProfilerAnimations = new YmlConfigConstructor(this, "commons/profileranimations/config.yml")).saveDefaultConfig();
        (MenusProfilerAnimations = new YmlConfigConstructor(this, "commons/profileranimations/menus.yml")).saveDefaultConfig();
        (ConfigStaff = new YmlConfigConstructor(this, "commons/staff/config.yml")).saveDefaultConfig();
        (MenusStaff = new YmlConfigConstructor(this, "commons/staff/menus.yml")).saveDefaultConfig();
        (ConfigUteis = new YmlConfigConstructor(this, "commons/uteis/config.yml")).saveDefaultConfig();
    }
}
