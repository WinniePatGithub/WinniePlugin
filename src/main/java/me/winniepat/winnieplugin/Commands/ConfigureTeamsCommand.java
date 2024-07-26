package me.winniepat.winnieplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class ConfigureTeamsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("configureteams") ) {

            String[] configureTeams = {
                    "team add Blau",
                    "team add Rot",
                    "team add Leiter",
                    "team modify Blau color blue",
                    "team modify Rot color red",
                    "team modify Leiter color aqua",
                    "team modify Blau prefix \"[Blau] \"",
                    "team modify Rot prefix \"[Rot] \"",
                    "team modify Leiter prefix \"[Leiter] \"",
                    "team modify Blau friendlyFire false",
                    "team modify Rot friendlyFire false",
                    "team modify Leiter friendlyFire false"
            };

            for (String element : configureTeams) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), element);
            }

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() +" permission unset winnieplugin.jointeam");

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say hi");

        }

        return false;
    }
}