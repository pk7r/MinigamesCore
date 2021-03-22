package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("jail|prender")
public class JailCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CommandCompletion("@players")
    public void onJailPlayer(Player p, String[] args) {
        if (!p.hasPermission("core.jail")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (args.length != 1) {
            m.sendMessage(p, "&cUso correto: /jail <jogador>");
            return;
        }
        Player t = Bukkit.getPlayerExact(args[0]);
        if (!Bukkit.getOnlinePlayers().contains(t)) {
            m.sendMessage(p, "&cJogador offline.");
            return;
        }
        if (m.getJail().contains(t)) {
            m.sendMessage(p, "&cEste jogador já está preso.");
            return;
        }
        m.sendMessage(p, "&aVocê prendeu &e" + t.getName() + "&a.");
        m.sendMessage(t, "&aVocê foi preso! Siga as instruções de &e" + p.getName() + "&a!");
        m.sendMessage(t, "&a6Deslogar agora irá te punir por &f60 dias &6automaticamente.");
        m.getJail().add(t);
    }
}
