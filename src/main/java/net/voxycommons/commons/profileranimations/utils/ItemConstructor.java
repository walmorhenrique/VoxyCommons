package net.voxycommons.commons.profileranimations.utils;

import org.bukkit.entity.*;
import org.bukkit.*;
import net.voxycommons.utils.*;
import me.clip.placeholderapi.*;
import java.util.stream.*;
import org.bukkit.inventory.*;

public class ItemConstructor {

    public static void setItems(Inventory inv, Player p) {
        if (inv.getItem(1) != null) return;

        for (final String category : YmlConfigurator.CProfilerAnimations.getConfigurationSection("profileranimations.Menu_Primario").getKeys(false)) {
            inv.setItem(YmlConfigurator.CProfilerAnimations.getInt("profileranimations.Menu_Primario." + category + ".slot"),
            new ItemBuilder(Material.getMaterial(YmlConfigurator.CProfilerAnimations.getString("profileranimations.Menu_Primario." + category + ".material")),
            1, (short)YmlConfigurator.CProfilerAnimations.getInt("profileranimations.Menu_Primario." + category + ".data"))
            .setName(YmlConfigurator.CProfilerAnimations.getString("profileranimations.Menu_Primario." + category + ".nome")
            .replace("&", "§")).setLore(YmlConfigurator.CProfilerAnimations.getStringList("profileranimations.Menu_Primario." + category + ".lore")
            .stream().map(lore -> PlaceholderAPI.setPlaceholders(p.getPlayer(), lore).replace("&", "§")).collect(Collectors.toList())).build());
        }
    }
    
    public static void removeItems(Inventory inv) {
        inv.setItem(1, (ItemStack)null);
        inv.setItem(2, (ItemStack)null);
        inv.setItem(3, (ItemStack)null);
        inv.setItem(4, (ItemStack)null);
    }
}
