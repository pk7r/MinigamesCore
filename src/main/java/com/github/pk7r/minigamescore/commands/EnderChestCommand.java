package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("enderchest|ec")
public class EnderChestCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    @CommandCompletion("@players")
    public void onEnderChest(Player p, String[] args) {
        if (!p.hasPermission("core.enderchest")) {
            m.sendMessage(p, "&cSem permissão");
            return;
        }
        if (args.length != 1) {
            m.sendMessage(p, "&aVocê abriu o seu enderchest.");
            p.openInventory(p.getEnderChest());
            return;
        }
        Player t = Bukkit.getPlayerExact(args[0]);
        if (!Bukkit.getOnlinePlayers().contains(t)) {
            m.sendMessage(p, "&cJogador offline.");
            return;
        }
        m.sendMessage(p, "&aVocê abriu o enderchest de &e" + t.getName() + "&a.");
        p.openInventory(t.getEnderChest());
    }
}
