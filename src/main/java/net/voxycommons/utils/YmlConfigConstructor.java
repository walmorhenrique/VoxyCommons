package net.voxycommons.utils;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class YmlConfigConstructor {

    private FileConfiguration config = null;

    private File file = null;

    private final boolean inPlugin;

    private final String subfolder;
    private final String filename;

    private final Plugin plugin;

    public YmlConfigConstructor(Plugin plugin, String filename, boolean internalFile, String... subfolder) {
        this.plugin = plugin;
        this.filename = filename;

        String path =  (subfolder.length > 0 ? subfolder[0] : "");
        this.subfolder = subfolder.length > 0 ? "plugins/" + plugin.getName() + "/" + subfolder[0] : "plugins/" + plugin.getName();

        if (inPlugin = internalFile) {
            try {
                File outFile = new File(this.subfolder, filename);
                InputStream stream = plugin.getClass().getResourceAsStream(path + "/" + filename);

                if(stream != null) FileUtils.copyInputStreamToFile(stream, outFile);
            } catch(Exception e) {
                Bukkit.getLogger().log(Level.WARNING, "Failed to create File " + filename, e);
            }
        }

        get().options().copyDefaults(true);
    }

    public FileConfiguration get() {
        if (config == null) {
            reload();
        }
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (Exception e) {
            plugin.getLogger().log(Level.WARNING, "Failed to save File " + file.getName(), e);
        }
    }

    public void reload() {
        file = new File(subfolder, filename);
        config = YamlConfiguration.loadConfiguration(file);
        if (inPlugin) {
            InputStream dataStream = plugin.getResource(filename);
            if (dataStream != null) {
                config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(dataStream)));
            }
        }
    }

    public File getFile() {
        if (file == null) {
            reload();
        }
        return file;
    }

}