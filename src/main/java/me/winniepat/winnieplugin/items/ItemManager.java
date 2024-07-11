package me.winniepat.winnieplugin.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack wand;

    public static boolean enabled = true;

    public static void init() {
        if(enabled) {
            createWand();
        }
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Ghosts Average Stick");
        List<String> lore = new ArrayList<>();
        lore.add("§7Man munkelt, dass Ghost einen Kleinen hat");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;

        if(enabled) {
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
            sr.shape("B  ",
                    " S ",
                    "  S");
            sr.setIngredient('B', Material.BLAZE_POWDER);
            sr.setIngredient('S', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("easteregg"), new ItemStack(Material.DRAGON_EGG, 1));
        sr2.shape(" C ",
                  "CRC",
                  "SSS");
        sr2.setIngredient('C', Material.END_CRYSTAL);
        sr2.setIngredient('R', Material.END_ROD);
        sr2.setIngredient('S', Material.END_STONE);
        Bukkit.getServer().addRecipe(sr2);
    }


}
