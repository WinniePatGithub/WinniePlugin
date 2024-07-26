package me.winniepat.winnieplugin.Commands;

import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WinniepatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("winniepat")) {
            String[] winniepat = {
                    "§7Ich bin der Admin, der diesen Server aufgebaut und dieses Plugin programmiert hat!",
                    "§7Schaut auch gerne bei meinen Socials vorbei, um mich zu unterstützen:",
                    "§7https://twitch.tv/winniepatgg"
            };
            for (String element : winniepat) {
                sender.sendMessage(WinniePlugin.pluginPrefix + element);
            }
        }
        return false;
    }
}