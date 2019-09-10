package uk.ocr.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.ocr.utility.StringUtils;
import uk.ocr.weapons.ThorHammer;

public class MakeThorCommand {

    public static boolean thorInUse = false;


    public boolean makeThorCommand(Player player) {
        if (!thorInUse) {
            player.getInventory().setHelmet(getThorHelmet());
            player.getInventory().setChestplate(getThorChestplate());
            player.getInventory().setLeggings(getThorLeggings());
            player.getInventory().setBoots(getThorBoots());
            player.getInventory().setItem(0, new ThorHammer());
            thorInUse = true;
        } else {
            player.sendMessage("Someone else is already " + StringUtils.rainbowString("THOR"));
        }
        return true;
    }

    public boolean removeThorCommand(Player player) {
        thorInUse = false;
        return true;
    }

    private ItemStack getThorHelmet() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        itemStack.getItemMeta().setDisplayName(StringUtils.rainbowString("Helmet of Nezelhunt"));
        return itemStack;
    }

    private ItemStack getThorChestplate() {
        ItemStack itemStack = new ItemStack(Material.IRON_CHESTPLATE);
        itemStack.getItemMeta().setDisplayName(StringUtils.rainbowString("Ornamental Chestplate"));
        return itemStack;
    }

    private ItemStack getThorLeggings() {
        ItemStack itemStack = new ItemStack(Material.IRON_LEGGINGS);
        itemStack.getItemMeta().setDisplayName(StringUtils.rainbowString("Azgardian of Legplates"));
        return itemStack;
    }

    private ItemStack getThorBoots() {
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        itemStack.getItemMeta().setDisplayName(StringUtils.rainbowString("Boots of Flight"));
        return itemStack;
    }

}
