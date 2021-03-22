package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandAlias("gamemode|gm")
public class GameModeCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    public void onGameMode(Player p) {
        if (!p.hasPermission("core.gamemode")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        m.sendMessage(p, "");
        m.sendMessage(p, "&f- &b/gamemode survival");
        m.sendMessage(p, "&f- &b/gamemode creative");
        m.sendMessage(p, "&f- &b/gamemode spectator");
        m.sendMessage(p, "");
    }

    @Subcommand("survival|0")
    public void survivalMode(Player p) {
        if (!p.hasPermission("core.gamemode")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (p.getGameMode().equals(GameMode.SURVIVAL)) {
            m.sendMessage(p, "&cVocê já está nesse modo de jogo.");
            return;
        }
        m.sendMessage(p, "&aModo de jogo alterado para &esobrevivência&a.");
        p.setGameMode(GameMode.SURVIVAL);
    }

    @Subcommand("creative|1")
    public void creativeMode(Player p) {
        if (!p.hasPermission("core.gamemode")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            m.sendMessage(p, "&cVocê já está nesse modo de jogo.");
            return;
        }
        m.sendMessage(p, "&aModo de jogo alterado para &ecriativo&a.");
        p.setGameMode(GameMode.CREATIVE);
    }

    @Subcommand("spectator|2")
    public void spectatorMode(Player p) {
        if (!p.hasPermission("core.gamemode")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (p.getGameMode().equals(GameMode.SPECTATOR)) {
            m.sendMessage(p, "&cVocê já está nesse modo de jogo.");
            return;
        }
        m.sendMessage(p, "&aModo de jogo alterado para &eespectador&a.");
        p.setGameMode(GameMode.SPECTATOR);
    }
}
