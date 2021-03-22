package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

@CommandAlias("vanish|v")
public class VanishCommand extends BaseCommand {

    private final Model m = Main.getModel();
    private final Main pl = Main.getMain();

    @Default @CatchUnknown
    public void onVanish(Player p) {

        if (!p.hasPermission("core.vanish")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (m.getVanish().contains(p)) {
            m.sendMessage(p, "&aVanish desativado com sucesso.");
            m.getVanish().remove(p);
            Bukkit.getOnlinePlayers().forEach(all ->
                    all.showPlayer(pl, p));
            p.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(9999, 4));
        } else {
            m.sendMessage(p, "&aVanish ativado com sucesso.");
            m.getVanish().add(p);
            Bukkit.getOnlinePlayers().forEach(all -> {
                if (!all.hasPermission("core.vanish.bypass")) {
                    all.hidePlayer(pl, p);
                }
            });
            p.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }
}
