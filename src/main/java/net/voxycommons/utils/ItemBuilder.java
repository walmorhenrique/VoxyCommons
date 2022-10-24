package net.voxycommons.utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemBuilder
{
    private ItemStack is;
    
    public ItemBuilder(final Material m) {
        this(m, 1);
    }
    
    public ItemBuilder(final ItemStack is) {
        this.is = is;
    }
    
    public ItemBuilder(final Material m, final int quantia) {
        this.is = new ItemStack(m, quantia);
    }
    
    public ItemBuilder(final Material m, final int quantia, final byte durabilidade) {
        this.is = new ItemStack(m, quantia, (short)durabilidade);
    }
    
    public ItemBuilder(final Material m, final int quantia, final int durabilidade) {
        this.is = new ItemStack(m, quantia, (short)durabilidade);
    }
    
    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }
    
    public ItemBuilder setDurability(final short durabilidade) {
        this.is.setDurability(durabilidade);
        return this;
    }
    
    public ItemBuilder setAmount(final int amount) {
        this.is.setAmount(amount);
        final ItemMeta im = this.is.getItemMeta();
        im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder setDurability(final String durabilidade) {
        this.is.setDurability((short)Short.valueOf(durabilidade));
        return this;
    }
    
    public ItemBuilder setName(final String nome) {
        final ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(nome);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder addUnsafeEnchantment(final Enchantment ench, final int level) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }
    
    public ItemBuilder removeEnchantment(final Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }
    
    public ItemBuilder setSkullOwner(final String dono) {
        try {
            final SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(dono);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException ex) {}
        return this;
    }
    
    public ItemBuilder addEnchant(final Enchantment ench, final int level) {
        final ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder addEnchantments(final Map<Enchantment, Integer> enchantments) {
        this.is.addEnchantments((Map)enchantments);
        return this;
    }
    
    public ItemBuilder setInfinityDurability() {
        this.is.setDurability((short)63);
        return this;
    }
    
    public ItemBuilder addItemFlag(final ItemFlag flag) {
        final ItemMeta im = this.is.getItemMeta();
        im.addItemFlags(new ItemFlag[] { flag });
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder setLore(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        im.setLore((List)Arrays.asList(lore));
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder setLore(final List<String> lore) {
        final ItemMeta im = this.is.getItemMeta();
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder removeLoreLine(final String linha) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> lore = new ArrayList<String>(im.getLore());
        if (!lore.contains(linha)) {
            return this;
        }
        lore.remove(linha);
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder removeLoreLine(final int index) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> lore = new ArrayList<String>(im.getLore());
        if (index < 0 || index > lore.size()) {
            return this;
        }
        lore.remove(index);
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder addLoreLine(final String linha) {
        final ItemMeta im = this.is.getItemMeta();
        List<String> lore = new ArrayList<String>();
        if (im.hasLore()) {
            lore = new ArrayList<String>(im.getLore());
        }
        lore.add(linha);
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder addLores(final List<String> linha) {
        final ItemMeta im = this.is.getItemMeta();
        List<String> lore = new ArrayList<String>();
        if (im.hasLore()) {
            lore = new ArrayList<String>(im.getLore());
        }
        for (final String s : linha) {
            lore.add(s);
        }
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder addLoreLine(final String linha, final int pos) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> lore = new ArrayList<String>(im.getLore());
        lore.set(pos, linha);
        im.setLore((List)lore);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder owner(final String owner) {
        try {
            final SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(owner);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException ex) {}
        return this;
    }
    
    public ItemBuilder lore(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> out = (im.getLore() == null) ? new ArrayList<String>() : im.getLore();
        final int i = lore.length;
        for (byte b = 0; b < i; ++b) {
            final String string = lore[b];
            out.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        im.setLore((List)out);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder setLore2(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> out = (im.getLore() == null) ? new ArrayList<String>() : im.getLore();
        final int i = lore.length;
        for (byte b = 0; b < i; ++b) {
            final String string = lore[b];
            out.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        im.setLore((List)out);
        this.is.setItemMeta(im);
        return this;
    }
    
    public ItemBuilder removeAttributes() {
        final ItemMeta meta = this.is.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        this.is.setItemMeta(meta);
        return this;
    }
    
    public ItemBuilder color(final Color color) {
        if (!this.is.getType().name().contains("LEATHER_")) {
            return this;
        }
        final LeatherArmorMeta meta = (LeatherArmorMeta)this.is.getItemMeta();
        meta.setColor(color);
        this.is.setItemMeta((ItemMeta)meta);
        return this;
    }
    
    public ItemBuilder setDyeColor(final DyeColor cor) {
        this.is.setDurability((short)cor.getDyeData());
        return this;
    }
    
    @Deprecated
    public ItemBuilder setWoolColor(final DyeColor cor) {
        if (!this.is.getType().equals((Object)Material.WOOL)) {
            return this;
        }
        this.is.setDurability((short)cor.getDyeData());
        return this;
    }
    
    public ItemBuilder setLeatherArmorColor(final Color cor) {
        try {
            final LeatherArmorMeta im = (LeatherArmorMeta)this.is.getItemMeta();
            im.setColor(cor);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException ex) {}
        return this;
    }
    
    public ItemStack toItemStack() {
        return this.is;
    }
    
    public ItemStack build() {
        return this.is;
    }
}
