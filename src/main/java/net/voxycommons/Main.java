package net.voxycommons;

import org.bukkit.plugin.java.*;
import net.voxycommons.utils.*;
import net.voxycommons.commons.*;
import com.henryfabio.minecraft.inventoryapi.manager.*;

import java.io.File;
import java.util.List;

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

    @Override
    public List<Class<?>> getDatabaseClasses() {
        return super.getDatabaseClasses();
    }

    public void onLoadConfig() {
        (Config = new YmlConfigConstructor(this, "config.yml", true)).save();
        (ConfigEssentials = new YmlConfigConstructor(this, "config.yml", true, "/commons/esentials")).save();
        (ConfigCuras = new YmlConfigConstructor(this, "config.yml", true, "/commons/curas")).save();
        (ConfigProfilerAnimations = new YmlConfigConstructor(this, "config.yml", true, "/commons/profileranimations")).save();
        (MenusProfilerAnimations = new YmlConfigConstructor(this, "menus.yml", true, "/commons/profileranimations")).save();
        (ConfigStaff = new YmlConfigConstructor(this, "config.yml", true, "/commons/staff")).save();
        (MenusStaff = new YmlConfigConstructor(this, "menus.yml", true, "/commons/staff")).save();
        (ConfigUteis = new YmlConfigConstructor(this, "config.yml", true,"/commons/uteis")).save();
    }
}
