package me.winniepat.winnieplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    private static void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerName = event.getPlayer().getName();
    }
}
