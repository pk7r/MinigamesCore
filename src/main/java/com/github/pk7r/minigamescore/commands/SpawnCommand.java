package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

@CommandAlias("spawn")
public class SpawnCommand extends BaseCommand {

    private final Model m = Main.getModel();
    private final Main pl = Main.getMain();

    @Default
    @CatchUnknown
    public void onSpawn(CommandSender s) {
        Player p = (Player) s;
        final World w = Bukkit.getServer().getWorld(Objects.requireNonNull(
                pl.getLocationsConfig().getString("spawn.world")));
        final double x = pl.getLocationsConfig().getDouble("spawn.x");
        final double y = pl.getLocationsConfig().getDouble("spawn.y");
        final double z = pl.getLocationsConfig().getDouble("spawn.z");
        final double yaw = pl.getLocationsConfig().getDouble("spawn.yaw");
        final double pitch = pl.getLocationsConfig().getDouble("spawn.pitch");
        final Location spawn = new Location(w, x, y, z, (float) yaw, (float) pitch);
        p.teleport(spawn);
        m.sendMessage(p, "&aTeleportado ao spawn.");
    }

    @Subcommand("set")
    public void onSetSpawn(CommandSender s) throws IOException {
        Player p = (Player) s;
        Location l = p.getLocation();
        if (!p.hasPermission("core.setspawn")) {
            m.sendMessage(p, "&cSem permissão.");
            return;
        }
        pl.getLocationsConfig().set("spawn.world",
                Objects.requireNonNull(l.getWorld()).getName());
        pl.getLocationsConfig().set("spawn.x", l.getX());
        pl.getLocationsConfig().set("spawn.y", l.getY());
        pl.getLocationsConfig().set("spawn.z", l.getZ());
        pl.getLocationsConfig().set("spawn.yaw", l.getYaw());
        pl.getLocationsConfig().set("spawn.pitch", l.getPitch());
        pl.getLocationsConfig().save(pl.getLocalesFile());
        m.sendMessage(p, "&aSpawn definido com sucesso.");
    }
}
