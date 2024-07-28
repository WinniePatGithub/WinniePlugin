package me.winniepat.winnieplugin.Commands;

import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class GetPointsCommand implements CommandExecutor {

    private final WinniePlugin winniePlugin;
    public GetPointsCommand(WinniePlugin winniePlugin) {
        this.winniePlugin = winniePlugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        try {
            if(args.length == 0 && sender instanceof Player p) {
                int points = winniePlugin.getPointsDatabase().getPlayerPoints(p);
                sender.sendMessage("§aDu hast §e" + points + "§a Punkte!");
                return true;
            }else {
                //Get the player
                String playerName = args[0];
                Player player = Bukkit.getServer().getPlayer(playerName);

                if(player == null) {
                    sender.sendMessage("§cSpieler nicht gefunden!");
                    return true;
                }

                //Get the amount
                int amount = winniePlugin.getPointsDatabase().getPlayerPoints(player);
                sender.sendMessage("§a" + player.getName() + " hat §e" + amount + "§a Punkte!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
