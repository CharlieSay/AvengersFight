package uk.co.ocr.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.ocr.equipment.Equipment;
import uk.co.ocr.avengers.AvengerPlayerWrapper;
import uk.co.ocr.utility.StringUtils;

public class MakeThorCommand {

    public boolean makeThorCommand(AvengerPlayerWrapper avengerPlayerWrapper) {
        Player player = avengerPlayerWrapper.getPlayer();
        Equipment equipment = avengerPlayerWrapper.getAvenger().getEquipment();
        player.sendTitle((ChatColor.MAGIC+"You are now Thor"), "Use the Mjölnir wisely.");
            player.getInventory().setHelmet(equipment.getHelmet());
            player.getInventory().setChestplate(equipment.getChestplate());
            player.getInventory().setLeggings(equipment.getLeggings());
            player.getInventory().setBoots(equipment.getBoots());
            player.getInventory().setItem(0,equipment.getPrimaryWeapon());
            player.sendMessage("Someone else is already " + StringUtils.rainbowString("THOR"));
            return true;
    }

}
