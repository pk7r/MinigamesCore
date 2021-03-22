package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.entity.Player;

@CommandAlias("god")
public class GodCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CatchUnknown
    public void onGod(Player p) {

        if (!p.hasPermission("core.god")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (m.getGod().contains(p)) {
            m.sendMessage(p, "&aGod desativado com sucesso.");
            m.getGod().remove(p);
        } else {
            m.sendMessage(p, "&aGod ativado com sucesso.");
            m.getGod().add(p);
        }
    }
}

