package net.voxycommons.commons.curas.events;

import net.voxycommons.commons.curas.MainCuras;
import net.voxycommons.utils.Utils;
import net.voxycommons.utils.YmlConfigurator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;

public class Events implements Listener {

    public static void useMedKit(Player p) {
        double vida = YmlConfigurator.CCuras.getDouble("curas.kitmedico.Cura");
        double vida2 = p.getHealth() + vida;
        double vida3 = (vida - p.getHealth()) / 2.0;
        DecimalFormat df = new DecimalFormat("#.#");

        if (vida + p.getHealth() < p.getMaxHealth()) {
            vida3 = vida / 2.0;

        } else vida3 = (p.getMaxHealth() - p.getHealth()) / 2.0;

        String used = YmlConfigurator.CCuras.getString("Actionbar.Curado").replace("<vida>", df.format(vida3)).replace("<coracao>", "❤").replace('&', '§');
        if (vida2 > 20.0) vida2 = 20.0;

        p.setHealth(vida2);
        Utils.sendAtionbar(p, used);
    }
    
    public static void useBandagem(Player p) {
        double vida = YmlConfigurator.CCuras.getDouble("curas.bandagem.Cura");
        double vida2 = p.getHealth() + vida;
        double vida3 = (vida - p.getHealth()) / 2.0;
        DecimalFormat df = new DecimalFormat("#.#");

        if (vida + p.getHealth() < p.getMaxHealth()) {
            vida3 = vida / 2.0;

        } else vida3 = (p.getMaxHealth() - p.getHealth()) / 2.0;

        String used = YmlConfigurator.CCuras.getString("Actionbar.Curado")
        .replace("<vida>", df.format(vida3)).replace("<coracao>", "❤")
        .replace('&', '§');

        if (vida2 > 20.0) vida2 = 20.0;

        p.setHealth(vida2);
        Utils.sendAtionbar(p, used);
    }
    
    public static void onQuitCuras(Player p) {
        if (!YmlConfigurator.Cconfig.getBoolean("commons.curas")) return;

        MainCuras.CurasDelayUse.remove(p.getUniqueId().toString());
        MainCuras.UseCura.remove(p.getUniqueId().toString());
    }
    
    public static void onDeathCuras(Player p) {
        if (!YmlConfigurator.Cconfig.getBoolean("commons.curas")) return;

        MainCuras.CurasDelayUse.remove(p.getUniqueId().toString());
        MainCuras.UseCura.remove(p.getUniqueId().toString());
    }
    
    public static void onInteractCuras(Player p, PlayerInteractEvent e) {
        if (!YmlConfigurator.Cconfig.getBoolean("commons.curas")) return;

        ItemStack item = e.getPlayer().getItemInHand();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Material kitmedico = Material.getMaterial(YmlConfigurator.CCuras.getString("curas.kitmedico.Item.Material"));
            Material bandagem = Material.getMaterial(YmlConfigurator.CCuras.getString("curas.bandagem.Item.Material"));
            String cheio = YmlConfigurator.CCuras.getString("Actionbar.Cheio").replace('&', '§');

            if (YmlConfigurator.CCuras.getBoolean("Options.Usar por nome")) {
                if (item.getType() == kitmedico && item.getItemMeta().hasDisplayName()) {

                    if (p.getMaxHealth() == p.getHealth()) {
                        Utils.sendAtionbar(p, cheio);
                        return;
                    }

                    if (MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) return;

                    if (p.getItemInHand().getAmount() > 1) {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

                    } else {
                        p.setItemInHand(null);
                        p.updateInventory();
                    }

                    MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), Double.parseDouble(Integer.toString(YmlConfigurator.CCuras.getInt("curas.kitmedico.Delay") + 1)));
                    MainCuras.UseCura.put(p.getUniqueId().toString(), "kitmedico");

                } else if (item.getType() == bandagem && item.getItemMeta().hasDisplayName()) {

                    if (p.getMaxHealth() == p.getHealth()) {
                        Utils.sendAtionbar(p, cheio);
                        return;
                    }

                    if (MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) return;

                    int amount = p.getItemInHand().getAmount();

                    if (amount > 1) {
                        p.getItemInHand().setAmount(amount - 1);

                    } else {
                        p.setItemInHand((ItemStack)null);
                        p.updateInventory();
                    }

                    MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), Double.parseDouble(Integer.toString(YmlConfigurator.CCuras.getInt("curas.bandagem.Delay") + 1)));
                    MainCuras.UseCura.put(p.getUniqueId().toString(), "bandagem");
                }

            } else if (item.getType() == kitmedico) {

                if (p.getMaxHealth() == p.getHealth()) {
                    Utils.sendAtionbar(p, cheio);
                    return;
                }

                if (MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) return;

                if (p.getItemInHand().getAmount() > 1) {
                    p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

                } else {
                    p.setItemInHand((ItemStack)null);
                    p.updateInventory();
                }

                MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), Double.parseDouble(Integer.toString(YmlConfigurator.CCuras.getInt("curas.kitmedico.Delay") + 1)));
                MainCuras.UseCura.put(p.getUniqueId().toString(), "kitmedico");

            } else if (item.getType() == bandagem) {

                if (p.getMaxHealth() == p.getHealth()) {
                    Utils.sendAtionbar(p, cheio);
                    return;
                }

                if (MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) return;

                int amount = p.getItemInHand().getAmount();

                if (amount > 1) {
                    p.getItemInHand().setAmount(amount - 1);

                } else {
                    p.setItemInHand((ItemStack)null);
                    p.updateInventory();
                }

                MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), Double.parseDouble(Integer.toString(YmlConfigurator.CCuras.getInt("curas.bandagem.Delay") + 1)));
                MainCuras.UseCura.put(p.getUniqueId().toString(), "bandagem");
            }
        }
    }
}
