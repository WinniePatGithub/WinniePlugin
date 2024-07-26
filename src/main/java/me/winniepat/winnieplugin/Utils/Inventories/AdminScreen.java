package me.winniepat.winnieplugin.Utils.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
        lore3.add("§4Aktiviert den OP Modus");
        lore3.add("§7Unendlich damage");
        lore3.add("§7Unendlich Herzen");
        lore3.add("§7etc");
        item = createItem("OP MODUS AN", Material.RED_STAINED_GLASS_PANE, lore3);
        _inventory.setItem(_inventory.firstEmpty(), item);

        List<String> lore4 = new ArrayList<>();
        lore4.add("§aDeaktiviert den OP Modus");
        lore4.add("§7Unendlich damage");
        lore4.add("§7Unendlich Herzen");
        lore4.add("§7etc");
        item = createItem("OP MODUS AUS", Material.LIME_STAINED_GLASS_PANE, lore4);
        _inventory.setItem(_inventory.firstEmpty(), item);

        List<String> lore5 = new ArrayList<>();
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, lore5);
        _inventory.setItem(_inventory.firstEmpty(), item);

        List<String> lore6 = new ArrayList<>();
        item = createItem("§aSetup", Material.BLUE_STAINED_GLASS_PANE, lore6);
        _inventory.setItem(_inventory.firstEmpty(), item);

        List<String> lore7 = new ArrayList<>();
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, lore7);
        _inventory.setItem(_inventory.firstEmpty(), item);

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
    public @NotNull Inventory getInventory() {
        return _inventory;
    }
}
