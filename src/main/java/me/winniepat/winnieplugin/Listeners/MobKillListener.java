package me.winniepat.winnieplugin.Listeners;

import me.winniepat.winnieplugin.WinniePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.sql.SQLException;

public class MobKillListener implements Listener {

    private final WinniePlugin winniePlugin;

    public MobKillListener(WinniePlugin winniePlugin) {
        this.winniePlugin = winniePlugin;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent e) throws SQLException {
        if(e.getEntity().getKiller() == null) return;

        Player killer = e.getEntity().getKiller();

        //get the players current points
        int points = winniePlugin.getPointsDatabase().getPlayerPoints(killer);
        int newPoints = (int) (Math.random() * 10) + 1;
        points += newPoints;

        winniePlugin.getPointsDatabase().updatePlayerPoints(killer, points);

        killer.sendMessage("§a+" + newPoints + " pts");
    }
}