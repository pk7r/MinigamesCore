package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("unjail|soltar")
public class UnJailCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CommandCompletion("@players")
    public void unJailPlayer(Player p, String[] args) {
        if (!p.hasPermission("core.jail")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (args.length != 1) {
            m.sendMessage(p, "&cUso correto: /unjail <jogador>");
            return;
        }
        Player t = Bukkit.getPlayerExact(args[0]);
        if (!Bukkit.getOnlinePlayers().contains(t)) {
            m.sendMessage(p, "&cJogador offline.");
            return;
        }
        if (!m.getJail().contains(t)) {
            m.sendMessage(p, "&cEste jogador não está preso.");
            return;
        }
        m.sendMessage(p, "&aVocê soltou &e" + t.getName() + "&a.");
        m.sendMessage(t, "&aVocê foi solto. Tenha um bom jogo!");
        m.getJail().remove(t);
    }
}
