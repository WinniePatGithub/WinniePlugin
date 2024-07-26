package me.winniepat.winnieplugin.Listeners;

import me.winniepat.winnieplugin.Utils.Items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements Listener {

    @EventHandler
    private static void onRightClick(PlayerInteractEvent event){
        if(event.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        } else if (event.getItem() == null) {
            return;
        } else if (!event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
            return;
        }
        Player player = event.getPlayer();
        player.getWorld().createExplosion(player.getLocation(), 20.0f);
    }
}
