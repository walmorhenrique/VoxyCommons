package net.voxycommons.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.voxycommons.commons.staff.playerlist.InfoHolderStaff;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.stream.Collectors;

public class InventoryConstructor {

    public static Inventory InvCreate(Player placeholderowner, Player owner, Player target, String menu, FileConfiguration config) {
        Inventory inv = Bukkit.createInventory(owner, 9 * config.getInt("Menus." + menu + ".tamanho"), config.getString("Menus." + menu + ".nome")
        .replace("&", "§").replace(config.getString("Menus." + menu + ".nome"),
        PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".nome")))
        .replace("{target}", target.getName()));

        for (String itens : config.getConfigurationSection("Menus." + menu + ".itens").getKeys(false)) {
            if (config.getBoolean("Menus." + menu + ".itens." + itens + ".skull.use")) {
                inv.setItem(config.getInt("Menus." + menu + ".itens." + itens + ".slot"),
                new SkullBuilder(config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name")
                .replace(config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name"),
                PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name")))
                .replace("{target}", target.getName()), config.getBoolean("Menus." + menu + ".itens." + itens + ".skull.link")).setDisplayName(config.getString("Menus." + menu + ".itens." + itens + ".nome")
                .replace(config.getString("Menus." + menu + ".itens." + itens + ".nome"), PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".nome")))
                .replace("&", "§").replace("{target}", target.getName())).setLore(config.getStringList("Menus." + menu + ".itens." + itens + ".lore")
                .stream().map(lore -> PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), lore).replace("&", "§").replace("{target}", target.getName())).collect(Collectors.toList())).build());

            } else {
                inv.setItem(config.getInt("Menus." + menu + ".itens." + itens + ".slot"),
                new ItemBuilder(Material.getMaterial(config.getString("Menus." + menu + ".itens." + itens + ".material")), 1, (short)config.getInt("Menus." + menu + ".itens." + itens + ".data"))
                .setName(config.getString("Menus." + menu + ".itens." + itens + ".nome").replace(config.getString("Menus." + menu + ".itens." + itens + ".nome"),
                PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".nome")))
                .replace("&", "§").replace("{target}", target.getName())).setLore(config.getStringList("Menus." + menu + ".itens." + itens + ".lore")
                .stream().map(lore -> PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), lore).replace("&", "§").replace("{target}", target.getName())).collect(Collectors.toList())).build());
            }
        }
        return inv;
    }
    
    public static Inventory InvCreateInfoHolder(Player placeholderowner, Player target, String menu, FileConfiguration config) {
        Inventory inv2 = Bukkit.createInventory(new InfoHolderStaff(target.getName()), 9 * config.getInt("Menus." + menu + ".tamanho"), config.getString("Menus." + menu + ".nome").replace("&", "§")
        .replace(config.getString("Menus." + menu + ".nome"),
        PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".nome")))
        .replace("{target}", target.getName()));

        for (String itens : config.getConfigurationSection("Menus." + menu + ".itens").getKeys(false)) {
            if (config.getBoolean("Menus." + menu + ".itens." + itens + ".skull.use")) {
                inv2.setItem(config.getInt("Menus." + menu + ".itens." + itens + ".slot"),
                new SkullBuilder(config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name")
                .replace(config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name"), PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".skull.skull-link-or-name")))
                .replace("{target}", target.getName()), config.getBoolean("Menus." + menu + ".itens." + itens + ".skull.link")).setDisplayName(config.getString("Menus." + menu + ".itens." + itens + ".nome")
                .replace(config.getString("Menus." + menu + ".itens." + itens + ".nome"),
                PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".nome")))
                .replace("&", "§").replace("{target}", target.getName())).setLore(config.getStringList("Menus." + menu + ".itens." + itens + ".lore").stream().map(lore -> PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), lore).replace("&", "§")
                .replace("{target}", target.getName())).collect(Collectors.toList())).build());

            } else {
                inv2.setItem(config.getInt("Menus." + menu + ".itens." + itens + ".slot"),
                new ItemBuilder(Material.getMaterial(config.getString("Menus." + menu + ".itens." + itens + ".material")), 1, (short)config.getInt("Menus." + menu + ".itens." + itens + ".data"))
                .setName(config.getString("Menus." + menu + ".itens." + itens + ".nome").replace(config.getString("Menus." + menu + ".itens." + itens + ".nome"),
                PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), config.getString("Menus." + menu + ".itens." + itens + ".nome"))).replace("&", "§")
                .replace("{target}", target.getName())).setLore(config.getStringList("Menus." + menu + ".itens." + itens + ".lore")
                .stream().map(lore -> PlaceholderAPI.setPlaceholders(placeholderowner.getPlayer(), lore).replace("&", "§").replace("{target}", target.getName())).collect(Collectors.toList())).build());
            }
        }
        return inv2;
    }
}
