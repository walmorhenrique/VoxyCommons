package net.voxycommons.utils;

import net.voxycommons.*;
import org.bukkit.plugin.java.*;
import org.bukkit.configuration.file.*;
import java.io.*;

public class YmlConfigConstructor {

    private final String fileName;
    private final Main plugin;
    private final File configFile;
    private FileConfiguration fileConfiguration;
    
    public YmlConfigConstructor(final JavaPlugin plugin, final String fileName) {
        if (plugin == null) {
            throw new IllegalArgumentException("plugin cannot be null");
        }
        this.plugin = (Main)plugin;
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
        if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            this.fileConfiguration.setDefaults(defConfig);
        }
    }
    
    public FileConfiguration getConfig() {
        if (this.fileConfiguration == null) {
            this.reloadConfig();
        }
        return this.fileConfiguration;
    }
    
    public void saveDefaultConfig() {
        if (!this.configFile.exists()) {
            this.plugin.saveResource(this.fileName, false);
        }
    }
}
