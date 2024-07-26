package me.winniepat.winnieplugin.Commands;

import me.winniepat.winnieplugin.Utils.Inventories.SelectionScreen;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JoinTeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("jointeam")) {
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage("§6Bitte suche dir ein Team aus!");
        }

        return false;
    }
}