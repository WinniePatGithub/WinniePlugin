package me.winniepat.winnieplugin.Listeners;

import me.winniepat.winnieplugin.Utils.Scoreboards.ScoreboardUtils;
import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class PlayerJoinListener implements Listener {

    private final WinniePlugin winniePlugin;

    public PlayerJoinListener(WinniePlugin winniePlugin) {
        this.winniePlugin = winniePlugin;
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) throws SQLException {



        String playerName = event.getPlayer().getName();
        event.getPlayer().setScoreboard(ScoreboardUtils.getBaseScoreboard(event.getPlayer()));
    }
}
