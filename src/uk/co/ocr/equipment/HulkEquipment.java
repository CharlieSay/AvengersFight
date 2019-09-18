package uk.co.ocr.equipment;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class HulkEquipment implements Equipment {
    @Override
    public ItemStack getPrimaryWeapon() {
        return null;
    }

    @Override
    public ItemStack getHelmet() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
        meta.setColor(Color.GREEN);
        meta.setDisplayName(ChatColor.GREEN + "HULKS HEAD");
        return itemStack;
    }

    @Override
    public ItemStack getChestplate() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
        meta.setColor(Color.GREEN);
        meta.setDisplayName(ChatColor.GREEN + "HULKS CHEST");
        return itemStack;
    }

    @Override
    public ItemStack getLeggings() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
        meta.setColor(Color.GREEN);
        meta.setDisplayName(ChatColor.GREEN + "HULKS HENCH LEGS");
        return itemStack;
    }

    @Override
    public ItemStack getBoots() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
        meta.setColor(Color.BLACK);
        meta.setDisplayName(ChatColor.GREEN + "HULKS BOOTS");
        return itemStack;
    }

    public void performPrimaryWeapon(Location location) {
        location.getWorld().playEffect(location, Effect.WITHER_SHOOT, 1, 1);
        location.getWorld().playSound(location, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
    }

    public ItemStack getSecondaryWeapon() {
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.UNDERLINE + "Just a stick");
        return itemStack;
    }
}
