package net.voxycommons.utils;

import net.voxycommons.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class YmlConfigConstructor {

    private final String fileName;
    private final Main plugin;
    private final File configFile;
    private FileConfiguration fileConfiguration;

    public YmlConfigConstructor(JavaPlugin plugin, String fileName) {
        if (plugin == null) {
            throw new IllegalArgumentException("plugin cannot be null");
        }

        this.plugin = (Main) plugin;
        this.fileName = fileName;
        final File dataFolder = plugin.getDataFolder();

        if (dataFolder == null) {
            throw new IllegalStateException();
        }

        this.configFile = new File(plugin.getDataFolder(), fileName);
    }

    public void reloadConfig() {

        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.configFile);
        final InputStream defConfigStream = this.plugin.getResource(this.fileName);

        /*if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            this.fileConfiguration.setDefaults(defConfig);
        }*/
    }

    public FileConfiguration getConfig() {

        if (this.fileConfiguration == null) {
            this.reloadConfig();
        }
        return this.fileConfiguration;
    }

    public void saveConfig() {
        if (this.fileConfiguration == null || this.configFile == null) {
            return;
        }

        try {
            this.getConfig().save(this.configFile);

        } catch (IOException ex) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, ex);
        }

    }

    public static void createConfig(String file) {
        if (!new File(Main.getInstance().getDataFolder(), file + ".yml").exists()) {
            Main.getInstance().saveResource(file + ".yml", false);
        }
    }

    public void saveDefaultConfig() {
        if (!this.configFile.exists()) {
            this.plugin.saveResource(this.fileName, false);
        }
    }
}
