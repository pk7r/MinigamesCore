package com.github.pk7r.minigamescore;

import com.github.pk7r.minigamescore.commands.CommandRegister;
import com.github.pk7r.minigamescore.listener.ListenerRegister;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    @Getter @Setter
    private static Model model;
    @Getter @Setter
    private static Main main;
    @Getter @Setter
    private static CommandSender sender;
    @Getter
    private final File localesFile = new File(getDataFolder(), "locales.yml");
    @Getter
    private final FileConfiguration locationsConfig = YamlConfiguration.loadConfiguration(getLocalesFile());


    @Override
    public void onEnable() {

        setSender(Bukkit.getConsoleSender());
        setMain(this);
        setModel(new Model());

        ListenerRegister listenerRegister = new ListenerRegister(this);
        CommandRegister commandRegister = new CommandRegister(this);

        if (!getLocalesFile().exists())
            saveResource("locales.yml", false);

        getSender().sendMessage("[MinigamesCore] Plugin carregado com sucesso!");
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        getSender().sendMessage("[MinigamesCore] Plugin desabilitado.");
    }

}
