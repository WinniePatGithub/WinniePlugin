package me.winniepat.winnieplugin.Utils.Scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtils {

    public static Scoreboard getBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main", "main", "§aKingdom Clash 2.0");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§aDiscord: www.dsc.gg/ghostsmoke").setScore(0);
        objective.getScore("§aIP: ghostsmoke.de").setScore(1);
        objective.getScore(" ").setScore(2);

        objective.getScore("§e").setScore(4);
        objective.getScore(player.isOp() ? "§cAdmin" : "§7Spieler").setScore(5);
        objective.getScore("§bDein Rang:").setScore(6);
        objective.getScore("§b").setScore(7);

        Team t = s.registerNewTeam("Online");
        t.addEntry("§b§c");
        objective.getScore("§b§c").setScore(3);
        t.setPrefix("§eSpielerzahl: " + Bukkit.getServer().getOnlinePlayers().size());


        return s;
    }
}