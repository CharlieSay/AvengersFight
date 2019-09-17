package uk.co.ocr.equipment;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.ocr.utility.StringUtils;

import java.util.Arrays;

public class ThorEquipment implements Equipment {

    public ItemStack getPrimaryWeapon(){
        ItemStack itemStack = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemStack.setType(Material.GOLDEN_AXE);
        itemStack.setAmount(1);
        itemMeta.setDisplayName(StringUtils.rainbowString("Mjölnir"));
        itemMeta.setLocalizedName("mjong");
        itemMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "The Mjölnir.",
                ChatColor.RED  + "Only owned by those worthy.",
                StringUtils.rainbowString("YOU ARE WORTHY OF THIS.")
        ));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getHelmet() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Helmet of Nezelhunt"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getChestplate() {
        ItemStack itemStack = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Ornamental Chestplate"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getLeggings() {
        ItemStack itemStack = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Azgardian of Legplates"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getBoots() {
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Boots of Flight"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
