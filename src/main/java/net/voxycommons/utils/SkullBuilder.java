package net.voxycommons.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Author: ClarkQuente
 * @GitHub: https://github.com/ClarkQuente
 */

/*
 * Como usar?
 * para criar uma cabeça com link do minecraft textures
 * ItemStack skull = new SkullBuilder("urldotexturesminecraft", true).build();
 * Obs: Pegue sua cabeça por esse site: (https://minecraft-heads.com/)
 * Para criar uma cabeça com nome
 * ItemStack skull = new SkullBuilder("urldotexturesminecraft", true).setDisplayName("&aNome da cabeça").toItemStack();
 * Para criar uma cabeça com lore
 * ItemStack skull = new SkullBuilder("urldotexturesminecraft", true).setLore("§aLore 1", "§aLore 2).toItemStack();
 * Pode criar quantas lores quiser basta por uma , depois de escrever uma linha
 * Como posso criar uma skull sendo a cabeça do player?
 * ItemStack skull = new SkullBuilder(player.getName(), false);
 * Pronto com isso você dará a cabeça do player
 * Se quiser dar sugestões/melhorias no código me chame no discord: (DaddyHenrique#0001)
 */

public class SkullBuilder {

    private ItemStack itemStack;
    private String url;
    private boolean useLink;

    public SkullBuilder(String url, boolean useLink) {
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 0, (byte) SkullType.PLAYER.ordinal());
        this.url = url;
        this.useLink = useLink;
    }

    public SkullBuilder setDisplayName(String name) {
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setDisplayName(name.replace("&", "§"));
        itemStack.setItemMeta(meta);
        return this;
    }

    public SkullBuilder setLore(List<String> lore) {
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return this;
    }

    public SkullBuilder setLore(String... lore) {
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {

        if(isLink()) {
            if (url == null || url.isEmpty()) {
                return null;
            }
            if (!getUrl().startsWith("http://textures.minecraft.net/texture/")) this.url = "http://textures.minecraft.net/texture/" + getUrl();
            try {
                SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
                GameProfile profile = new GameProfile(UUID.nameUUIDFromBytes(getUrl().getBytes()), null);
                profile.getProperties().put("textures", new Property("textures", new String(Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", getUrl()).getBytes()))));
                Field profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
                itemStack.setItemMeta(skullMeta);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return itemStack;
        }

        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(getUrl());
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public String getUrl() {
        return url;
    }

    public boolean isLink() {
        return useLink;
    }
}