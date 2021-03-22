package com.github.pk7r.minigamescore.listener;

import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodListener implements Listener {

    private final Model m = Main.getModel();

    @EventHandler
    public void onDamaged(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (m.getGod().contains(e.getEntity())) {
                e.setCancelled(true);
            }
        }
    }
}
