package me.winniepat.winnieplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionScreen implements InventoryHolder {

    private Inventory inv;

    public SelectionScreen() {
        inv = Bukkit.createInventory(this, 9, "Team Auswahl");
        init();
    }

    private void init() {
        ItemStack item;
        for (int i = 0; i < 4; i++) {
            item = createItem("§9§lBlau", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList("§7Team Blau"));
            inv.setItem(i, item);
        }

        List<String> lore = new ArrayList<>();
        lore.add("§7Suche dir dein Team aus, um diesem Beizutreten!");
        lore.add("§7TEST");
        item = createItem("§b§lSuch dir dein Team aus!", Material.BOOK, lore);
        inv.setItem(inv.firstEmpty(), item);

        for (int i = 5; i < 9; i++) {
            item = createItem("§c§lRot", Material.RED_STAINED_GLASS_PANE, Collections.singletonList("§7Team Rot"));
            inv.setItem(i, item);
        }
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
