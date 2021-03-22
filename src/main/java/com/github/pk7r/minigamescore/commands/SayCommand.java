package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("say")
public class SayCommand extends BaseCommand {

    private final Model m = Main.getModel();
    private final Main pl = Main.getMain();

    @Default
    public void onBroadCast(Player p, String[] args) {

        StringBuilder b = new StringBuilder();

        if (!p.hasPermission("core.say")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        for (String msg : args) {
            b.append(msg).append(" ");
        }
        Bukkit.getScheduler().runTaskAsynchronously(pl, () ->
                Bukkit.getOnlinePlayers().forEach(all ->
                        m.sendMessage(all, "&d[" + p.getName() +"] " + b.toString())));
    }
}
