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

@CommandAlias("tp")
public class TeleportCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default @CommandCompletion("@players")
    public void onTeleport(Player p, String[] args) {

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
        Location l = t.getLocation();
        p.teleport(l);
        m.sendMessage(p, "&aTeleportado para &e" + t.getName() + "&a.");
    }
}
