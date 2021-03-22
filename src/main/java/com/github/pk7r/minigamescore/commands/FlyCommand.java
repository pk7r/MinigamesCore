package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.entity.Player;

@CommandAlias("fly")
public class FlyCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CatchUnknown
    public void onFly(Player p) {
        if (!p.hasPermission("core.fly")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (p.isFlying()) {
            p.setFlying(false);
            p.setAllowFlight(false);
            m.sendMessage(p, "&aFly desativado com sucesso.");
        } else {
            p.setFlying(true);
            p.setAllowFlight(true);
            m.sendMessage(p, "&aFly ativado com sucesso.");
        }
    }
}
