package uk.ocr.weapons;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;

public class GlazHammer {

    public ItemStack itemStack;

    public GlazHammer(ItemStack itemStack) {
        this.itemStack = itemStack;
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(Color.BLUE + "Glaz Hammer");
    }

}
