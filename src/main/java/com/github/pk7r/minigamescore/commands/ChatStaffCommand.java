package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("s")
public class ChatStaffCommand extends BaseCommand {

    private final Model m = Main.getModel();
    private final Main pl = Main.getMain();

    @Default
    public void onChat(Player p, String[] args) {

        String prefix = PlaceholderAPI.setPlaceholders(p, "%vault_prefix%");
        StringBuilder b = new StringBuilder();

        if (!p.hasPermission("core.chatstaff")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        for (String msg : args) {
            b.append(msg).append(" ");
        }
        Bukkit.getScheduler().runTaskAsynchronously(pl, () ->
                Bukkit.getOnlinePlayers().forEach(all -> {
                    if (all.hasPermission("core.chatstaff")) {
                        m.sendMessage(all, b.toString());
                    }
                }));
    }
}
