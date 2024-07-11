package me.winniepat.winnieplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminScreen implements InventoryHolder {

    private Inventory inv;

    public AdminScreen() {
        inv = Bukkit.createInventory(this, 18, "Team Auswahl");
        init();
    }

    private void init() {
        ItemStack item;

        List<String> lore1 = new ArrayList<>();
        lore1.add("§7Startet das Event.");
        lore1.add("§cNicht umkehrbar");
        item = createItem("§aStart Event", Material.GREEN_STAINED_GLASS_PANE, lore1);
        inv.setItem(inv.firstEmpty(), item);

        List<String> lore2 = new ArrayList<>();
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, lore2);
        inv.setItem(inv.firstEmpty(), item);

        List<String> lore3 = new ArrayList<>();
        lore3.add("§7Konfiguriert alle Sachen");
        lore3.add("§7Weil ich zu faul bin, mehrere Commands auszuführen");
        item = createItem("Setup", Material.LIGHT_BLUE_STAINED_GLASS_PANE, lore3);
        inv.setItem(inv.firstEmpty(), item);

        List<String> lore4 = new ArrayList<>();
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, lore4);
        inv.setItem(inv.firstEmpty(), item);

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
