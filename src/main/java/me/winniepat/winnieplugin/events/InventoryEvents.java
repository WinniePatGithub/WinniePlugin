package me.winniepat.winnieplugin.events;

import me.winniepat.winnieplugin.inventories.AdminScreen;
import me.winniepat.winnieplugin.inventories.SelectionScreen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof SelectionScreen) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team leave " + player.getName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team join Blau " + player.getName());
                player.sendMessage(ChatColor.YELLOW + "Du bist Team Blau beigetreten!");
                player.closeInventory();
            } else if (e.getSlot() == 4) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Suche dir dein Team aus, um diesem beizutreten!");
            } else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team leave " + player.getName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team join Rot " + player.getName());
                player.sendMessage(ChatColor.YELLOW + "Du bist Team Rot beigetreten!");
                player.closeInventory();
            }

        }

        if (e.getClickedInventory().getHolder() instanceof AdminScreen) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null) {
                return;
            }
            if(e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "startevent");
                player.sendMessage(ChatColor.DARK_RED + "MUSS ICH NOCH FERTIG CODEN");
            }
            if(e.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "configureteams");

                player.sendMessage("Erfolgreich ausgeführt!");
            }

        }
    }
}


