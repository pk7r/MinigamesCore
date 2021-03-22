package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("invsee")
public class InvSeeCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CommandCompletion("@players")
    public void onInvSee(Player p, String[] args) {
        if (!p.hasPermission("core.invsee")) {
            m.sendMessage(p, "&cSem permissão");
            return;
        }
        if (args.length != 1) {
            m.sendMessage(p, "&cUso correto: /invsee <jogador>");
            return;
        }
        Player t = Bukkit.getPlayerExact(args[0]);
        if (!Bukkit.getOnlinePlayers().contains(t)) {
            m.sendMessage(p, "&cJogador offline.");
            return;
        }
        m.sendMessage(p, "&aVocê abriu o inventário de &e" + t.getName() + "&a.");
        p.openInventory(t.getInventory());
    }
}
