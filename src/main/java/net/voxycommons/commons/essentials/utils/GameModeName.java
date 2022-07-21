package net.voxycommons.commons.essentials.utils;

import org.bukkit.GameMode;

public enum GameModeName {
    ADVENTURE("aventura"),
    CREATIVE("criativo"),
    SPECTATOR("espectador"),
    SURVIVAL("sobrevivência");

    private final String name;

    private GameModeName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static GameModeName valueOf(GameMode gamemode) {
        return valueOf(gamemode.name());
    }

    public String toString() {
        return this.name;
    }
}
