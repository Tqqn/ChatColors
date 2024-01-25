package com.tqqn.chatcolors.gui;

import com.tqqn.chatcolors.colors.Colors;
import com.tqqn.chatcolors.data.PluginPlayer;
import com.tqqn.chatcolors.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColorGUI {

    private final PluginPlayer player;
    private final Inventory inventory;

    public ChatColorGUI(PluginPlayer player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, Colors.NONE.getSize(), ChatUtils.format("<red>ChatColor menu"));
        initInventoryItems();
    }

    private void initInventoryItems() {
        int slot = 0;
        for (Colors colors : Colors.values()) {
            if (colors.equals(Colors.NONE)) continue;
            inventory.setItem(slot, createGUIItem(colors, player.getSelectedColor().equals(colors)));
            slot++;
        }

        inventory.setItem(slot, createGUIItem(Colors.NONE, player.getSelectedColor().equals(Colors.NONE)));
    }

    private ItemStack createGUIItem(Colors color, boolean isChosen) {

        ItemStack itemStack = new ItemStack(color.getGuiMaterial());
        ItemMeta meta = itemStack.getItemMeta();
        Component name;

        if (isChosen) {
            name = ChatUtils.format("<aqua>[Selected] " + color.getPrettyName());
            meta.addEnchant(Enchantment.DURABILITY, 0, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            name = ChatUtils.format(color.getPrettyName());
        }

        meta.displayName(name);
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public void openInventory() {
        player.getPlayer().openInventory(inventory);
    }

    public void closeInventory() {
        player.getPlayer().closeInventory();
    }
}
