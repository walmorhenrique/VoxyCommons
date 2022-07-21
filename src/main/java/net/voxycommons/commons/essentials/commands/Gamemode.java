package net.voxycommons.commons.essentials.commands;

import net.voxycommons.commons.essentials.utils.GameModeName;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.voxycommons.utils.YmlConfigurator.CEssentials;

public class Gamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission(CEssentials.getString("Mensagens.Permissions.permission"))) {
            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.SemPermissao").replace("&","§"));
            return false;
        }

        GameMode on;

        if (!(sender instanceof Player)) {
            if (args.length != 2) {
                sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Utilize").replace("&","§"));
                return true;

            } else {
                Player p = Bukkit.getPlayer(args[1]);
                if (p == null) {
                    sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.JogadorNaoEncontrado").replace("&","§"));
                    return true;

                } else {
                    GameMode news = getNewGameMode(args[0]);
                    if (news == null) {
                        sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Invalido").replace("{gamemode}", args[0]).replace("&","§"));
                        return true;

                    } else {

                        on = p.getGameMode();

                        if (on.equals(news)) {
                            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.JaEstaOutro").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player}", p.getName()).replace("&","§"));
                            return true;

                        } else {

                            p.setGameMode(news);
                            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.AlteradoOutro").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player}", p.getName()).replace("&","§"));

                            for (Player b : Bukkit.getOnlinePlayers()) {
                                if (b.hasPermission(CEssentials.getString("Mensagens.Permissions.permission-log"))) {
                                    b.sendMessage(CEssentials.getString("Mensagens.Gamemode.LogOutros").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player2}", p.getName()).replace("{player}", sender.getName()).replace("&","§"));
                                }
                            }
                            return true;
                        }
                    }
                }
            }

        } else if (args.length <= 2 && args.length >= 1) {

            GameMode news;
            Player p;

            if (args.length == 2) {
                if (!sender.hasPermission(CEssentials.getString("Mensagens.Permissions.permission other"))) {
                    sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.SemPermissaoOutros").replace("&","§"));
                    return true;

                } else {
                    news = getNewGameMode(args[0]);
                    if (news == null) {
                        sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Invalido").replace("{gamemode}", args[0]).replace("&","§"));
                        return true;

                    } else {
                        p = Bukkit.getPlayer(args[1]);
                        if (p == null) {
                            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.JogadorNaoEncontrado").replace("&","§"));
                            return true;

                        } else {
                            on = p.getGameMode();
                            if (on.equals(news)) {
                                sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.JaEstaOutro").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player}", p.getName()).replace("&","§"));
                                return true;

                            } else {

                                p.setGameMode(news);
                                sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.AlteradoOutro").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player}", p.getName()).replace("&","§"));

                                for (Player b : Bukkit.getOnlinePlayers()) {
                                    if (b.hasPermission(CEssentials.getString("Mensagens.Permissions.permission-log"))) {
                                        b.sendMessage(CEssentials.getString("Mensagens.Gamemode.LogOutros").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player2}", p.getName()).replace("{player}", sender.getName()).replace("&","§"));
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }

            } else {
                news = this.getNewGameMode(args[0]);

                if (news == null) {
                    sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Invalido").replace("{gamemode}", args[0]).replace("&","§"));
                    return true;

                } else {

                    p = (Player)sender;
                    on = p.getGameMode();

                    if (on.equals(news)) {
                        sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.JaEsta").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("&","§"));
                        return true;

                    } else {
                        boolean hasPerm = hasPermission(news, p);

                        if (!hasPerm) {
                            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.SemPermissaoEspecifico").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("&","§"));
                            return true;

                        } else {

                            p.setGameMode(news);
                            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Alterado").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("&","§"));

                            for (Player b : Bukkit.getOnlinePlayers()) {
                                if (b.hasPermission(CEssentials.getString("Mensagens.Permissions.permission-log")) && b != sender) {
                                    b.sendMessage(CEssentials.getString("Mensagens.Gamemode.Log").replace("{gamemode}", GameModeName.valueOf(news).getName()).replace("{player}", sender.getName()).replace("&","§"));
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        } else {
            sender.sendMessage(CEssentials.getString("Mensagens.Gamemode.Utilize").replace("&","§"));
            return true;
        }
    }

    private boolean hasPermission(GameMode gm, Player p) {
        String perm = CEssentials.getString("Mensagens.Permissions.permission specific") + gm.name().toLowerCase().replace("&","§");
        return p.hasPermission(perm);
    }

    private GameMode getNewGameMode(String gamemode) {
        try {
            int gm = Integer.parseInt(gamemode);

            try {
                return GameMode.getByValue(gm);
            } catch (Throwable var6) {
                return null;
            }
        } catch (NumberFormatException var7) {
            String gm = gamemode.toUpperCase();

            try {
                return GameMode.valueOf(gm);
            } catch (Throwable var5) {
                return null;
            }
        }
    }
}
