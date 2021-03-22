package com.github.pk7r.minigamescore.listener;

import com.github.pk7r.minigamescore.Main;
import org.bukkit.plugin.PluginManager;

public class ListenerRegister {

    public ListenerRegister(Main plugin) {

        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new FirstJoinListener(), plugin);
        pm.registerEvents(new GodListener(), plugin);
        pm.registerEvents(new JailListener(), plugin);
        pm.registerEvents(new JoinMessageListener(), plugin);
        pm.registerEvents(new QuitListener(), plugin);
        pm.registerEvents(new RespawnListener(), plugin);
        pm.registerEvents(new SpawnOnJoinListener(), plugin);

    }
}