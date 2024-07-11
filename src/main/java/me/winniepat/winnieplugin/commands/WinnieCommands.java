package me.winniepat.winnieplugin.commands;

import me.winniepat.winnieplugin.WinniePlugin;
import me.winniepat.winnieplugin.inventories.AdminScreen;
import me.winniepat.winnieplugin.inventories.SelectionScreen;
import me.winniepat.winnieplugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WinnieCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command cmd,@NotNull String label,@NotNull String[] args) {
        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        // /heal
        if(cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
        }

        // /feed
        if(cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
        }

        // /jointem
        if(cmd.getName().equalsIgnoreCase("jointeam")) {
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.GOLD + "Bitte suche dir ein Team aus!");
        }

        // /configureteams
        if (cmd.getName().equalsIgnoreCase("configureteams") ) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team add Blau");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team add Rot");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team add Leiter");

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Blau color blue");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Rot color red");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Leiter color aqua");


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Blau prefix \"[Blau] \"");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Rot prefix \"[Rot] \"");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Leiter prefix \"[Leiter] \"");


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Blau friendlyFire false");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Rot friendlyFire false");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Leiter friendlyFire false");

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() +" permission unset winnieplugin.jointeam");

        }

        // /ghostsmoke
        if(cmd.getName().equalsIgnoreCase("ghostsmoke")) {
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Danke an Ghost, dass er diesen Server ermöglicht!");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Schaut gerne auf seinen Socials vorbei:");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "https://twitch.tv/ghostsmokegg");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "https://www.youtube.com/@GhostSmokeGG");
        }

        // /winniepat
        if(cmd.getName().equalsIgnoreCase("winniepat")) {
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Ich bin der Admin, der diesen Server aufgebaut und dieses Plugin programmiert hat!");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Schaut auch gerne bei meinen Socials vorbei, um mich zu unterstützen:");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "https://twitch.tv/winniepatgg");
        }

        // /givewand
        if(cmd.getName().equalsIgnoreCase("givewand")) {
            player.getInventory().addItem(ItemManager.wand);
        }

        // /help
        if(cmd.getName().equalsIgnoreCase("help")) {
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Bei Fragen kannst du gerne WinniePatGG oder Ghostsmoke auf Discord schreiben!");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "Commands:");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "/ghostsmoke");
            sender.sendMessage(WinniePlugin.pluginPrefix + ChatColor.GRAY + "/winniepat");

        }

        // /teamwechsel
        if (cmd.getName().equalsIgnoreCase("teamwechsel")) {
            sender.sendMessage(ChatColor.DARK_RED + "MUSS ICH NOCH CODEN");
        }

        // /admin
        if(cmd.getName().equalsIgnoreCase("admin")) {
            AdminScreen gui = new AdminScreen();
            player.openInventory(gui.getInventory());
        }

        // /startevent

        // /togglewand


        return false;
    }
}
