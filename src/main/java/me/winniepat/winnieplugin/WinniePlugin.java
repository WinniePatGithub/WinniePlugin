package me.winniepat.winnieplugin;

import me.winniepat.winnieplugin.Commands.*;
import me.winniepat.winnieplugin.Listeners.*;
import me.winniepat.winnieplugin.Utils.Items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class WinniePlugin extends JavaPlugin {

    public static final String pluginPrefix = "§b[Kingdom Clash 2.0] §r";

    @Override
    public void onEnable() {
        ItemManager.init();

        RegisterCommands();
        RegisterListeners();

        getServer().getConsoleSender().sendMessage("§aWinniePlugin wurde erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§cWinniePlugin wurde erfolgreich deaktiviert!");
    }
}
