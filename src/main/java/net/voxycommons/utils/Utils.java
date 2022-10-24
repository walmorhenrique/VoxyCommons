package net.voxycommons.utils;

import com.google.common.base.Strings;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Utils {
    public Utils() {
    }

    public static void sendAtionbar(Player p, String message) {
        IChatBaseComponent icbc = ChatSerializer.a("{\"text\":\"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }

    public static String getProgressBar(int current, int max, int totalBars, char symbol, ChatColor completedColor, ChatColor notCompletedColor) {
        float percent = (float)current / (float)max;
        int progressBars = (int)((float)totalBars * percent);
        return Strings.repeat("" + notCompletedColor + symbol, totalBars - progressBars) + Strings.repeat("" + completedColor + symbol, progressBars);
    }

    public static void sendTitle(Player p, String title, String subtitle, int time) {
        if (title != null) {
            sendPacket(new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\": \"" + title + "\"}"), 20, time * 20, 20), p);
        }

        if (subtitle != null) {
            sendPacket(new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\": \"" + subtitle + "\"}"), 20, time * 20, 20), p);
        }

    }

    public static void resetTitle(Player p) {
        sendPacket(new PacketPlayOutTitle(EnumTitleAction.RESET, (IChatBaseComponent)null), p);
    }

    public static void sendPacket(Packet pa, Player p) {
        CraftPlayer cp = (CraftPlayer)p;
        cp.getHandle().playerConnection.sendPacket(pa);
    }
}