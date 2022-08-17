package net.voxycommons;
//74

import com.henryfabio.minecraft.inventoryapi.manager.InventoryManager;
import net.voxycommons.utils.YmlConfigConstructor;
import org.bukkit.plugin.java.JavaPlugin;

import static net.voxycommons.commons.MainCommons.loadCommons;
import static net.voxycommons.commons.MainCommons.unloadCommons;

public final class Main extends JavaPlugin {

    public static YmlConfigConstructor Config;
    public static YmlConfigConstructor ConfigEssentials;
    public static YmlConfigConstructor ConfigStaff;
    public static YmlConfigConstructor MenusStaff;
    public static YmlConfigConstructor ConfigProfilerAnimations;
    public static YmlConfigConstructor MenusProfilerAnimations;

    public static Main getInstance() {return getPlugin(Main.class);}

    @Override
    public void onEnable() {
        onLoadConfig();
        InventoryManager.enable(this);
        loadCommons();
    }

    @Override
    public void onDisable() {
        unloadCommons();
    }

    public void onLoadConfig() {
        (Config = new YmlConfigConstructor(this, "Config.yml")).saveDefaultConfig();
        (ConfigEssentials = new YmlConfigConstructor(this, "Commons/Essentials/Config.yml")).saveDefaultConfig();
        (ConfigProfilerAnimations = new YmlConfigConstructor(this, "Commons/ProfilerAnimations/Config.yml")).saveDefaultConfig();
        (MenusProfilerAnimations = new YmlConfigConstructor(this, "Commons/ProfilerAnimations/Menus.yml")).saveDefaultConfig();
        (ConfigStaff = new YmlConfigConstructor(this, "Commons/Staff/Config.yml")).saveDefaultConfig();
        (MenusStaff = new YmlConfigConstructor(this, "Commons/Staff/Menus.yml")).saveDefaultConfig();
    }
}
