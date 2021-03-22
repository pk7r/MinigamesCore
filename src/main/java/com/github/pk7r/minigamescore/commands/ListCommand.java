package com.github.pk7r.minigamescore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.pk7r.minigamescore.Main;
import com.github.pk7r.minigamescore.Model;
import de.themoep.minedown.MineDown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@CommandAlias("list|online")
public class ListCommand extends BaseCommand {

    private final Model m = Main.getModel();
    private final Main pl = Main.getMain();

    @Default @CatchUnknown
    public void onList(Player p) {

        List<String> ignorar = pl.getConfig().getStringList("list.ignore").stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        long on = Bukkit.getOnlinePlayers().stream()
                .filter(online -> !m.getVanish().contains(online))
                .filter(online -> !ignorar.contains(online.getName().toLowerCase())).count();

        m.sendMessage(p, "&a&m----------------------------------------------------");
        m.sendMessage(p, String.format("&bAtualmente temos &f%s&b jogadores online.", on));
        Set<String> listed = new HashSet<>();
        Objects.requireNonNull(pl.getConfig().getConfigurationSection("list.classes")).getKeys(false)
                .forEach(key -> {
                    String permission = pl.getConfig().getString("list.classes." + key + ".permission");
                    List<String> names = Bukkit.getOnlinePlayers().stream()
                            .filter(online -> !m.getVanish().contains(online))
                            .filter(online -> !ignorar.contains(online.getName().toLowerCase()))
                            .filter(online -> !listed.contains(online.getName()))
                            .filter(online -> online.hasPermission(Objects.requireNonNull(permission)))
                            .map(Player::getName)
                            .collect(Collectors.toList());

                    listed.addAll(names);
                    String group = pl.getConfig().getString("list.classes." + key + ".name");
                    p.spigot().sendMessage(names.isEmpty()
                            ? (MineDown.parse(String.format("&cNão tem nenhum %s online.", group)))
                            : (MineDown.parse(String.format("&e%s(s): &9%s", group,
                            names.stream().map(Object::toString)
                            .collect(Collectors.joining(", "))))));
                });
        m.sendMessage(p, "&a&m----------------------------------------------------");
    }
}
