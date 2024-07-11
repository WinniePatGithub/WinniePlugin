package me.winniepat.winnieplugin;

import me.winniepat.winnieplugin.commands.WinnieCommands;
import me.winniepat.winnieplugin.events.InventoryEvents;
import me.winniepat.winnieplugin.events.WinnieEvents;
import me.winniepat.winnieplugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class WinniePlugin extends JavaPlugin {

    public static final String pluginPrefix = ChatColor.AQUA + "[Kingdom Clash 2.0] " + ChatColor.RESET;

    @Override
    public void onEnable() {
        WinnieCommands commands = new WinnieCommands();

        ItemManager.init();

        getServer().getPluginManager().registerEvents(new WinnieEvents(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);

        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("jointeam").setExecutor(commands);
        getCommand("ghostsmoke").setExecutor(commands);
        getCommand("winniepat").setExecutor(commands);
        getCommand("givewand").setExecutor(commands);
        getCommand("help").setExecutor(commands);
        getCommand("configureteams").setExecutor(commands);
        getCommand("teamwechsel").setExecutor(commands);
        getCommand("admin").setExecutor(commands);
        getCommand("startevent").setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "WinniePlugin wurde erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "WinniePlugin wurde erfolgreich deaktiviert!");
    }
}
