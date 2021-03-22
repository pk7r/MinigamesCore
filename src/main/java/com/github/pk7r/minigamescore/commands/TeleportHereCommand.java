package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("tphere")
public class TeleportHereCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    @CommandCompletion("@players")
    public void onTeleportHere(Player p, String[] args) {

        if (!p.hasPermission("core.tp")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        Player t = Bukkit.getPlayerExact(args[0]);

        if (!Bukkit.getOnlinePlayers().contains(t)) {
            m.sendMessage(p, "&cJogador offline.");
            return;
        }
        assert t != null;
        Location l = p.getLocation();
        t.teleport(l);
        m.sendMessage(p, "&aVocê teleportou &e" + t.getName() + "&a até você.");
    }
}
