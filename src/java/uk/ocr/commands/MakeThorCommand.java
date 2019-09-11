package java.uk.ocr.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.uk.ocr.utility.StringUtils;
import java.uk.ocr.weapons.ThorHammer;

public class MakeThorCommand {

    public static boolean thorInUse = false;

    public boolean makeThorCommand(Player player) {
        if (!thorInUse) {
            player.getInventory().setHelmet(getThorHelmet());
            player.getInventory().setChestplate(getThorChestplate());
            player.getInventory().setLeggings(getThorLeggings());
            player.getInventory().setBoots(getThorBoots());
            player.getInventory().setItem(0, new ThorHammer());
            player.sendTitle(StringUtils.rainbowString("You are now Thor"), "Use the Mjölnir wisely.");
            thorInUse = true;
        } else {
            player.sendMessage("Someone else is already " + StringUtils.rainbowString("THOR"));
        }
        return true;
    }

    public boolean removeThorCommand(Player player) {
        player.getInventory().remove(getThorBoots());
        player.getInventory().remove(getThorHelmet());
        player.getInventory().remove(getThorLeggings());
        player.getInventory().remove(getThorChestplate());
        player.getInventory().remove(new ThorHammer());
        thorInUse = false;
        return true;
    }

    private ItemStack getThorHelmet() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        if (itemStack.hasItemMeta()){
            itemStack.getItemMeta().setDisplayName(StringUtils.rainbowString("Helmet of Nezelhunt"));
        }
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
