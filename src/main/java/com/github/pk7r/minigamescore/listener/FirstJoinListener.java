package com.github.pk7r.minigamescore.listener;

import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListener implements Listener {

    private final Model m = Main.getModel();

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPlayedBefore()) {
            m.broadcastMessage("&d" + p.getName() + " é um novato, ajude-o!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "
                    + p.getName() + " parent addtemp novato 24h");
        }
    }
}
