package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("clear")
public class ClearCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    @CommandCompletion("@players")
    public void onTeleport(Player p, String[] args) {

        if (!p.hasPermission("core.clear")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (args.length != 1) {
            p.getInventory().clear();
            m.sendMessage(p, "&aSeu inventário foi limpo com sucesso.");
        } else {
            Player t = Bukkit.getPlayerExact(args[0]);

            if (!Bukkit.getOnlinePlayers().contains(t)) {
                m.sendMessage(p, "&cJogador offline.");
                return;
            }
            assert t != null;
            t.getInventory().clear();
            m.sendMessage(t, "&aSeu inventário foi limpo por &e" + p.getName() + "&a.");
            m.sendMessage(p, "&aVocê limpou o inventário de &e" + t.getName() + "&a com sucesso.");
        }
    }
}
