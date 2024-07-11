package me.winniepat.winnieplugin.events;

import me.winniepat.winnieplugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WinnieEvents implements Listener {

     @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
         Player player = event.getPlayer();
         String playerName = event.getPlayer().getName();
         player.sendMessage(ChatColor.LIGHT_PURPLE + "Willkommen " + playerName + "!");

     }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerName = event.getPlayer().getName();

    }

     @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
         if (event.getAction() == Action.RIGHT_CLICK_AIR) {
             if(event.getItem() != null) {
                 if(event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
                     Player player = event.getPlayer();
                     player.getWorld().createExplosion(player.getLocation(), 20.0f);
                     player.sendMessage("Ghost hat nen Kleinen");
                 }
             }
         }
     }
}
