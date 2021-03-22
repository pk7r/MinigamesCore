package com.github.pk7r.minigamescore.listener;

import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessageListener implements Listener {

    private final Model m = Main.getModel();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        e.setJoinMessage(null);
        m.getVanish().remove(p);
        m.getGod().remove(p);
        if (!p.hasPermission("core.bypassjoin"))
        m.broadcastMessage("&7[&6+&7] &e" + p.getName() + " entrou");
    }
}