package me.winniepat.winnieplugin;

import me.winniepat.winnieplugin.Commands.*;
import me.winniepat.winnieplugin.Listeners.*;
import me.winniepat.winnieplugin.Utils.Config;
import me.winniepat.winnieplugin.Utils.Database.PointsDatabase;
import me.winniepat.winnieplugin.Utils.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;

public final class WinniePlugin extends JavaPlugin {

    public static final String pluginPrefix = "§b[Kingdom Clash 2.0] §r";

    private Config locations;
    private PointsDatabase pointsDatabase;

    @Override
    public void onEnable() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }

            pointsDatabase = new PointsDatabase(getDataFolder().getAbsolutePath() + "/winnieplugin.db");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect to the database! " + ex.getMessage());
            Bukkit.getPluginManager().disablePlugin(this);
        }


        saveDefaultConfig();
        if(getConfig().getBoolean("test")) {
            getLogger().info(getConfig().getString("msg"));
        }
        locations = new Config("locations.yml", getDataFolder());


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
        Objects.requireNonNull(getCommand("setpoints")).setExecutor(new SetPointsCommand(this));
        Objects.requireNonNull(getCommand("points")).setExecutor(new GetPointsCommand(this));
    }

    private void RegisterListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new MobKillListener(this), this );
    }

    public PointsDatabase getPointsDatabase() {
        return this.pointsDatabase;
    }

    @Override
    public void onDisable() {
        try{
            pointsDatabase.closeConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        getServer().getConsoleSender().sendMessage("§cWinniePlugin wurde erfolgreich deaktiviert!");
    }

    public Config getLocations() {
        return locations;
    }
}
