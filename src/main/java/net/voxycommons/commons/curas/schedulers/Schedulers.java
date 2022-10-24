package net.voxycommons.commons.curas.schedulers;

import org.bukkit.entity.*;
import net.voxycommons.commons.curas.*;
import net.voxycommons.commons.curas.events.*;
import org.bukkit.*;
import net.voxycommons.utils.*;

public class Schedulers {

    public static void SchedulerCuras(final Player p) {

        if (!YmlConfigurator.Cconfig.getBoolean("commons.curas")) return;

        if (MainCuras.UseCura.containsValue("kitmedico") && MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) {
            String kitmedico = YmlConfigurator.CCuras.getString("Actionbar.Delay kitmedico").replace('&', '§');
            Double registrado = MainCuras.CurasDelayUse.get(p.getUniqueId().toString());

            if (registrado == null) return;

            if (!p.isOnline() || registrado <= 1.0) {

                if (p.getHealth() < 0.0 || p.isDead()) return;

                Events.useMedKit(p);
                MainCuras.CurasDelayUse.remove(p.getUniqueId().toString());
                MainCuras.UseCura.remove(p.getUniqueId().toString());

            } else {
                double delay = registrado - 1.0;
                String progress = Utils.getProgressBar((int) delay, 6, 5, '|', ChatColor.GRAY, ChatColor.GREEN);
                Utils.sendAtionbar(p, kitmedico.replace("<progress>", progress).replace("<item>", YmlConfigurator.CCuras.getString("Item nome.kitmedico")).replace("<tempo>", String.valueOf(registrado - 1.0)).replace(".0", "").replace("&", "§"));
                MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), registrado - 1.0);
            }

        } else if (MainCuras.UseCura.containsValue("bandagem") && MainCuras.CurasDelayUse.containsKey(p.getUniqueId().toString())) {
            String bandagem = YmlConfigurator.CCuras.getString("Actionbar.Delay bandagem").replace('&', '§');
            Double registrado = MainCuras.CurasDelayUse.get(p.getUniqueId().toString());

            if (registrado == null) return;

            if (!p.isOnline() || registrado <= 1.0) {

                if (p.getHealth() < 0.0 || p.isDead()) return;

                Events.useBandagem(p);
                MainCuras.CurasDelayUse.remove(p.getUniqueId().toString());
                MainCuras.UseCura.remove(p.getUniqueId().toString());

            } else {
                double delay = registrado - 1.0;
                String progress = Utils.getProgressBar((int) delay, 4, 3, '|', ChatColor.RED, ChatColor.GREEN);
                Utils.sendAtionbar(p, bandagem.replace("<progress>", progress).replace("<item>", YmlConfigurator.CCuras.getString("Item nome.bandagem")).replace("<tempo>", String.valueOf(registrado - 1.0)).replace(".0", "").replace("&", "§"));
                MainCuras.CurasDelayUse.put(p.getUniqueId().toString(), registrado - 1.0);
            }
        }
    }
}
