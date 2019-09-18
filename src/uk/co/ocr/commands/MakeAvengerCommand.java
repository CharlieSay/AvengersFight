package uk.co.ocr.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.ocr.avengers.Avenger;
import uk.co.ocr.equipment.Equipment;

public class MakeAvengerCommand {

    public boolean makeThorCommand(Player player, Avenger avenger) {
        Equipment equipment = avenger.getEquipment();
        player.sendTitle((ChatColor.MAGIC + "You are now Thor"), "Use the Mjölnir wisely.");
        return setInventory(player, equipment);
    }

    public boolean makeHulkCommand(Player player, Avenger avenger) {
        Equipment equipment = avenger.getEquipment();
        player.sendTitle((ChatColor.GREEN + "You are now Hulk"), "HULK SMASH.");
        return setInventory(player, equipment);
    }

    private boolean setInventory(Player player, Equipment equipment) {
        player.getInventory().setHelmet(equipment.getHelmet());
        player.getInventory().setChestplate(equipment.getChestplate());
        player.getInventory().setLeggings(equipment.getLeggings());
        player.getInventory().setBoots(equipment.getBoots());
        player.getInventory().setItem(0, equipment.getPrimaryWeapon());
        return true;
    }
}
