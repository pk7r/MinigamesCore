package com.github.pk7r.minigamescore;

import de.themoep.minedown.MineDown;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Data
public class Model {

    private List<Player> vanish = new ArrayList<>();
    private List<Player> god = new ArrayList<>();
    private List<Player> jail = new ArrayList<>();


    public void sendMessage(Player player, String message) {
        player.spigot().sendMessage(MineDown.parse(message));
    }

    public void broadcastMessage(String message) {
        Bukkit.getOnlinePlayers().forEach(all ->
                all.spigot().sendMessage(MineDown.parse(message)));
    }
}
