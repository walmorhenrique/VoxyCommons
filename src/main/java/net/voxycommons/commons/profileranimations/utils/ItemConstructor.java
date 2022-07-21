package net.voxycommons.commons.profileranimations.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.voxycommons.utils.ItemBuilder;
import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.stream.Collectors;

public class ItemConstructor {

    public static void setItems(Inventory inv, Player p) {
        if(inv.getItem(1) != null)
            return;

        for(String category : YmlConfigurator.CProfilerAnimations.getConfigurationSection("ProfilerAnimations.Menu_Primario").getKeys(false)) {
        inv.setItem(YmlConfigurator.CProfilerAnimations.getInt("ProfilerAnimations.Menu_Primario." + category + ".slot"),
        new ItemBuilder(Material.getMaterial(YmlConfigurator.CProfilerAnimations.getString("ProfilerAnimations.Menu_Primario." + category + ".material")), 1,
        (short) YmlConfigurator.CProfilerAnimations.getInt("ProfilerAnimations.Menu_Primario." + category + ".data"))
        .setName(YmlConfigurator.CProfilerAnimations.getString("ProfilerAnimations.Menu_Primario." + category + ".nome").replace("&", "§"))
        .setLore(YmlConfigurator.CProfilerAnimations.getStringList("ProfilerAnimations.Menu_Primario." + category + ".lore").stream().map(lore -> PlaceholderAPI.setPlaceholders(p.getPlayer(), lore).replace("&", "§")).collect(Collectors.toList())).build());
        }

    }

    public static void removeItems(Inventory inv) {
        inv.setItem(1, null);
        inv.setItem(2, null);
        inv.setItem(3, null);
        inv.setItem(4, null);
    }

}
