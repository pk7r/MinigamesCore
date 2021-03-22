package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import de.themoep.minedown.MineDown;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

@CommandAlias("tploc")
public class TeleportLocationCommand extends BaseCommand {

    private final Model m = Main.getModel();

    @Default
    @CommandCompletion("@worlds")
    public void onDefault(Player p, String[] args) {

        if (!p.hasPermission("core.teleport")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
            if (args.length != 4) {
                p.spigot().sendMessage(MineDown.parse("&cUso correto: /tploc <mundo> <x> <y> <z>"));
                return;
            }
            World w = Bukkit.getWorld(args[0]);
            double x = Double.parseDouble(args[1]);
            double y = Double.parseDouble(args[2]);
            double z = Double.parseDouble(args[3]);
            final Location l = new org.bukkit.Location(w, x, y, z);
            p.teleport(l);
            p.spigot().sendMessage(MineDown.parse("&aTeleportado com sucesso."));
    }
}
