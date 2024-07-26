package me.winniepat.winnieplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ClearchatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("clearchat")) {
            Player p = (Player) sender;

            if (p.hasPermission("winnieplugin.clearchat.admin")) {
                for (int i = 0; i < 50; i++) {
                    Bukkit.broadcastMessage("");
                }

                Bukkit.broadcastMessage(" §6|-------------------+====+-------------------|");
                Bukkit.broadcastMessage("§l Der Chat wurde von " + p.getName() + " gecleared!");
                Bukkit.broadcastMessage(" §6|-------------------+====+-------------------|");

                return true;
            }
        }

        return false;
    }
}