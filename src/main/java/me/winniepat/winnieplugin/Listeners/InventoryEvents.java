package me.winniepat.winnieplugin.Listeners;

import me.winniepat.winnieplugin.Utils.Inventories.AdminScreen;
import me.winniepat.winnieplugin.Utils.Inventories.SelectionScreen;
import org.bukkit.Bukkit;
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
                player.sendMessage("§eDu bist Team Blau beigetreten!");
                player.closeInventory();
            } else if (e.getSlot() == 4) {
                player.sendMessage("§dSuche dir dein Team aus, um diesem beizutreten!");
            } else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team leave " + player.getName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),   "team join Rot " + player.getName());
                player.sendMessage("§eDu bist Team Rot beigetreten!");
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
                player.sendMessage("§4MUSS ICH NOCH FERTIG CODEN");
            }
            if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                String[] removeAttributes = {
                        " minecraft:generic.attack_damage base set 1",
                        " minecraft:generic.attack_speed base set 4",
                        " minecraft:generic.max_health base set 20",
                        " minecraft:generic.knockback_resistance base set 0",
                        " minecraft:generic.armor_toughness base set 0"
                };

                for (String element : removeAttributes) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute " + player.getName() + element);
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear " + player.getName() + " minecraft:regeneration");
                player.sendMessage("§aOP Modus deaktiviert!");
            }

            if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                String[] addAttributes = {
                        " minecraft:generic.attack_damage base set 1000000",
                        " minecraft:generic.attack_speed base set 1000000",
                        " minecraft:generic.max_health base set 1000000",
                        " minecraft:generic.knockback_resistance base set 1000000",
                };

                for (String element : addAttributes) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute " + player.getName() + element);
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"effect give " + player.getName() + " minecraft:regeneration 99999 255 true");
                player.sendMessage("§cOP Modus aktiviert!");
            }
            if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tell " + player.getName() + " Ghost hat nen Kleinen \uD83D\uDC4D");
            }
            if(e.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "configureteams");

                player.sendMessage("§aServer wurde erfolgreich eingerichtet!");
            }

        }
    }
}


