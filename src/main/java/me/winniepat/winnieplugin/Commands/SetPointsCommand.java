package me.winniepat.winnieplugin.Commands;

import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class SetPointsCommand implements CommandExecutor {

    private final WinniePlugin winniePlugin;

    public SetPointsCommand(WinniePlugin winniePlugin) {
        this.winniePlugin = winniePlugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length != 2) {
            sender.sendMessage("§e/setpoints <spieler> <anzahl>");
            return true;
        }

        //get the player
        String playerName = args[0];
        Player target = Bukkit.getPlayer(playerName);
        if(target == null) {
            sender.sendMessage("§cDieser Spieler wurde nicht in der Datenbank gefunden!");
            return true;
        }

        //get the amount
        int amount = 0;
        try{
            amount = Integer.parseInt(args[1]);
        }catch (NumberFormatException e) {
            sender.sendMessage("§cDie Anzahl muss eine ganze Zahl sein!");
            return true;
        }

        //Update the player's points in the db
        try{
            this.winniePlugin.getPointsDatabase().updatePlayerPoints(target, amount);
            sender.sendMessage("§aDie Punkte von §e" + target.getName() + " wurden auf §e" + amount + " §agesetzt!");
        }catch (SQLException ex) {
            ex.printStackTrace();
            sender.sendMessage("§cEtwas ist beim updaten schief gelaufen!");
        }

        return true;
    }
}
