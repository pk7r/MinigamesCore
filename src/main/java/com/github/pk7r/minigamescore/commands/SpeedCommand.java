package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import de.themoep.minedown.MineDown;
import org.bukkit.entity.Player;

@CommandAlias("speed")
public class SpeedCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    @CommandCompletion("@range:1-10")
    public void onDefault(Player p, String[] args) {

        if (p.hasPermission("core.speed")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        if (args.length != 1) {
            p.spigot().sendMessage(MineDown.parse("&cUso correto: /speed <velocidade>"));
            return;
        }
        double speed = Double.parseDouble(args[0]);
        float value = ((float) speed) / 10;
        if (speed < 0 || speed > 10) {
            p.spigot().sendMessage(MineDown.parse("&cUso correto: /speed <velocidade>"));
            return;
        }
        try {
            p.setWalkSpeed(value);
            if (p.isFlying()) {
                p.setFlySpeed(value);
            }
            p.spigot().sendMessage(MineDown.parse("&aVelocidade alterada para &e" + speed + "&a."));
        } catch (NumberFormatException e) {
            p.spigot().sendMessage(MineDown.parse("&cUso correto: /speed <velocidade>"));
        }
    }
}
