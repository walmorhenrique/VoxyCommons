package net.voxycommons.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder {
    private ItemStack itemStack;
    private String url;
    private boolean useLink;

    public SkullBuilder(String url, boolean useLink) {
        this.itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)0, (byte)SkullType.PLAYER.ordinal());
        this.url = url;
        this.useLink = useLink;
    }

    public SkullBuilder setDisplayName(String name) {
        SkullMeta meta = (SkullMeta)this.itemStack.getItemMeta();
        meta.setDisplayName(name.replace("&", "§"));
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public SkullBuilder setLore(List<String> lore) {
        SkullMeta meta = (SkullMeta)this.itemStack.getItemMeta();
        meta.setLore(lore);
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public SkullBuilder setLore(String... lore) {
        SkullMeta meta = (SkullMeta)this.itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        SkullMeta skullMeta;
        if (this.isLink()) {
            if (this.url != null && !this.url.isEmpty()) {
                if (!this.getUrl().startsWith("http://textures.minecraft.net/texture/")) {
                    this.url = "http://textures.minecraft.net/texture/" + this.getUrl();
                }

                try {
                    skullMeta = (SkullMeta)this.itemStack.getItemMeta();
                    GameProfile profile = new GameProfile(UUID.nameUUIDFromBytes(this.getUrl().getBytes()), (String)null);
                    profile.getProperties().put("textures", new Property("textures", new String(Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", this.getUrl()).getBytes()))));
                    Field profileField = skullMeta.getClass().getDeclaredField("profile");
                    profileField.setAccessible(true);
                    profileField.set(skullMeta, profile);
                    this.itemStack.setItemMeta(skullMeta);
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                return this.itemStack;
            } else {
                return null;
            }
        } else {
            skullMeta = (SkullMeta)this.itemStack.getItemMeta();
            skullMeta.setOwner(this.getUrl());
            this.itemStack.setItemMeta(skullMeta);
            return this.itemStack;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isLink() {
        return this.useLink;
    }
}