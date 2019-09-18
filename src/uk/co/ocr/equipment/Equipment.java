package uk.co.ocr.equipment;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface Equipment {

    ItemStack getPrimaryWeapon();

    ItemStack getSecondaryWeapon();

    ItemStack getHelmet();

    ItemStack getChestplate();

    ItemStack getLeggings();

    ItemStack getBoots();

    void performPrimaryWeapon(Location location);

}
