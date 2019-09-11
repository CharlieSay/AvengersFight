package uk.co.ocr.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.ocr.utility.StringUtils;

import java.awt.*;
import java.util.Arrays;

public class MakeThorCommand {

    public static boolean thorInUse = false;

    public boolean makeThorCommand(Player player) {
//        if (!thorInUse) {
            player.sendTitle((ChatColor.MAGIC+"You are now Thor"), "Use the Mjölnir wisely.");
            player.getInventory().setHelmet(getThorHelmet());
            player.getInventory().setChestplate(getThorChestplate());
            player.getInventory().setLeggings(getThorLeggings());
            player.getInventory().setBoots(getThorBoots());
            player.getInventory().setItem(0, getThorHammer());
            thorInUse = true;
//        } else {
            player.sendMessage("Someone else is already " + StringUtils.rainbowString("THOR"));
//        }
        return true;
    }

    public boolean removeThorCommand(Player player) {
        player.getInventory().remove(getThorBoots());
        player.getInventory().remove(getThorHelmet());
        player.getInventory().remove(getThorLeggings());
        player.getInventory().remove(getThorChestplate());
        player.getInventory().remove(getThorHammer());
        thorInUse = false;
        return true;
    }

    private ItemStack getThorHelmet() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Helmet of Nezelhunt"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private ItemStack getThorChestplate() {
        ItemStack itemStack = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Ornamental Chestplate"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private ItemStack getThorLeggings() {
        ItemStack itemStack = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Azgardian of Legplates"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private ItemStack getThorBoots() {
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString("Boots of Flight"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private ItemStack getThorHammer() {
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
}
