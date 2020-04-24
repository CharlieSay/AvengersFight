package uk.co.ayth.equipment;

import org.bukkit.*;
import org.bukkit.persistence.PersistentDataType;
import uk.co.ayth.utility.StringUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ThorEquipment implements Equipment {

    public ItemStack getPrimaryWeapon(){
        ItemStack itemStack = new ItemStack(Material.GOLDEN_AXE);
        itemStack.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
        itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemStack.setAmount(1);
        itemMeta.setDisplayName(ChatColor.RED + "Mjölnir");
        itemMeta.setLocalizedName("mjong");
        itemMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "The Mjölnir.",
                ChatColor.RED  + "Only owned by those worthy.",
                StringUtils.rainbowString("YOU ARE WORTHY OF THIS.")
        ));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void performPrimaryWeapon(Location location){

    }

    public ItemStack getSecondaryWeapon() {
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.UNDERLINE + "Just a stick");
        return itemStack;
    }

    public ItemStack getHelmet() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        itemStack.setItemMeta(assignDisplayName("Helmet of Nezelhunt", itemStack));
        return itemStack;
    }

    public ItemStack getChestplate() {
        ItemStack itemStack = new ItemStack(Material.IRON_CHESTPLATE);
        itemStack.setItemMeta(assignDisplayName("Ornamental Chestplate", itemStack));
        return itemStack;
    }

    public ItemStack getLeggings() {
        ItemStack itemStack = new ItemStack(Material.IRON_LEGGINGS);
        itemStack.setItemMeta(assignDisplayName("Azgardian of Legplates", itemStack));
        return itemStack;
    }

    public ItemStack getBoots() {
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        itemStack.setItemMeta(assignDisplayName("Boots of Flight", itemStack));
        return itemStack;
    }

    private ItemMeta assignDisplayName(String displayName, ItemStack itemStack){
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.rainbowString(displayName));
        return itemMeta;
    }

}
