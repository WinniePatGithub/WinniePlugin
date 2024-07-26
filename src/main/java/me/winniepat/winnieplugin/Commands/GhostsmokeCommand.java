package me.winniepat.winnieplugin.Commands;

import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GhostsmokeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("ghostsmoke")) {
            String[] ghostsmoke = {
                    "§7Danke an Ghost, dass er diesen Server ermöglicht!",
                    "§7Schaut gerne auf seinen Socials vorbei:",
                    "§7https://twitch.tv/ghostsmokegg",
                    "§7https://www.youtube.com/@GhostSmokeGG",
                    "§7Danke an Ghost, dass er diesen Server ermöglicht!"
            };
            for (String element : ghostsmoke) {
                sender.sendMessage(WinniePlugin.pluginPrefix + element);
            }
        }
        return false;
    }
}