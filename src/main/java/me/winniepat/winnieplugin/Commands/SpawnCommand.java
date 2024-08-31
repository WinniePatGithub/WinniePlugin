package me.winniepat.winnieplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }

        if(cmd.getName().equalsIgnoreCase("Spawn")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:tp " + sender.getName() + " 100 206 100");
        }
        return false;
    }

}
