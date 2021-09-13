package kheeto.handcuff.items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HandcuffsKeys {

    public static ItemStack customItem;

    public static void setUp() {
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta data = item.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(Color.WHITE + "Attacca un giocatore ammanettato");
        lore.add(Color.WHITE + "mentre hai le chiavi in mano");
        lore.add(Color.WHITE + "per liberarlo.");

        // Set custom item data
        data.setDisplayName(ChatColor.YELLOW + "Chiavi delle Manette");
        data.setLore(lore);
        data.setUnbreakable(true);
        data.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        // Apply the custom item data to the item
        item.setItemMeta(data);
        customItem = item;
    }
}
