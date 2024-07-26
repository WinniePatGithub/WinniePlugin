package me.winniepat.winnieplugin;

import me.winniepat.winnieplugin.Commands.*;
import me.winniepat.winnieplugin.Listeners.*;
import me.winniepat.winnieplugin.Utils.Items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class WinniePlugin extends JavaPlugin {

    public static final String pluginPrefix = "§b[Kingdom Clash 2.0] §r";

    @Override
    public void onEnable() {
        ItemManager.init();

        RegisterCommands();
        RegisterListeners();

        getServer().getConsoleSender().sendMessage("§aWinniePlugin wurde erfolgreich aktiviert!");
    }

    private void RegisterCommands() {
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("jointeam")).setExecutor(new JoinTeamCommand());
        Objects.requireNonNull(getCommand("ghostsmoke")).setExecutor(new GhostsmokeCommand());
        Objects.requireNonNull(getCommand("winniepat")).setExecutor(new WinniepatCommand());
        Objects.requireNonNull(getCommand("givewand")).setExecutor(new GivewandCommand());
        Objects.requireNonNull(getCommand("configureteams")).setExecutor(new ConfigureTeamsCommand());
        Objects.requireNonNull(getCommand("teamwechsel")).setExecutor(new TeamwechselCommand());
        Objects.requireNonNull(getCommand("admin")).setExecutor(new AdminCommand());
        Objects.requireNonNull(getCommand("startevent")).setExecutor(new StarteventCommand());
        Objects.requireNonNull(getCommand("clearchat")).setExecutor(new ClearchatCommand());
    }

    private void RegisterListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§cWinniePlugin wurde erfolgreich deaktiviert!");
    }
}
