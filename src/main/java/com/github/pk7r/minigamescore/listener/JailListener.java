package com.github.pk7r.minigamescore.listener;

import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class JailListener implements Listener {

    private final Model m = Main.getModel();

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (m.getJail().contains(p)) {
            e.setCancelled(true);
            m.sendMessage(p, "&cVocê não pode se mover enquanto estiver preso.");
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();

        if (m.getJail().contains(p)) {
            e.setCancelled(true);
            m.sendMessage(p, "&cVocê não pode usar commandos enquanto estiver preso.");
        }
    }
}
