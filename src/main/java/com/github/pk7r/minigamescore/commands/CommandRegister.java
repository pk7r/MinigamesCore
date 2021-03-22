package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.PaperCommandManager;
import com.github.pk7r.minigamescore.Main;

public class CommandRegister {

    public CommandRegister(Main plugin) {

        PaperCommandManager m = new PaperCommandManager(plugin);

        m.registerCommand(new BroadCastCommand());
        m.registerCommand(new ChatStaffCommand());
        m.registerCommand(new ClearCommand());
        m.registerCommand(new EnderChestCommand());
        m.registerCommand(new FlyCommand());
        m.registerCommand(new GameModeCommand());
        m.registerCommand(new GodCommand());
        m.registerCommand(new InvSeeCommand());
        m.registerCommand(new JailCommand());
        m.registerCommand(new ListCommand());
        m.registerCommand(new SayCommand());
        m.registerCommand(new SpawnCommand());
        m.registerCommand(new SpeedCommand());
        m.registerCommand(new TeleportCommand());
        m.registerCommand(new TeleportHereCommand());
        m.registerCommand(new TeleportLocationCommand());
        m.registerCommand(new UnJailCommand());
        m.registerCommand(new VanishCommand());

    }
}