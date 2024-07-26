package me.winniepat.winnieplugin.Listeners;

import me.winniepat.winnieplugin.Utils.Scoreboards.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    private static void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage("§a\uD83E\uDC7A§r§3 " + playerName);
        event.getPlayer().setScoreboard(ScoreboardUtils.getBaseScoreboard(event.getPlayer()));
    }
}
