package uk.co.ocr.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import uk.co.ocr.avengers.Avenger;
import uk.co.ocr.equipment.Equipment;

public class MakeAvengerCommand {

    private static boolean thorInUse = false;

    public boolean makeThorCommand(Player player, Avenger avenger) {
        if (!thorInUse){
            Equipment equipment = avenger.getEquipment();
            player.sendTitle((ChatColor.MAGIC + "You are now Thor"), "Use the Mjölnir wisely.", 20, 100,20);
            player.spawnParticle(avenger.getParticle(), player.getLocation(), 10);
            player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
            thorInUse = true;
            return setInventory(player, equipment);
        }
        player.sendMessage("Thor Already in use.");
        return false;
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
