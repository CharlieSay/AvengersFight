package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import uk.co.ayth.avengers.Avenger;
import uk.co.ayth.equipment.Equipment;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import uk.co.ayth.utility.StringUtils;

import java.util.Optional;

public class MakeAvengerCommand {

    private static Optional<Player> thorInUseBy = Optional.empty();

    public boolean makeThorCommand(Player player, Avenger avenger) {
        if (player.isOp()){

        if (!thorInUseBy.isPresent()){
            Equipment equipment = avenger.getEquipment();
            player.sendTitle((ChatColor.RED + "You are now Thor"), "Use the Mjölnir wisely.", 20, 100,20);
            player.spawnParticle(avenger.getParticle(), player.getLocation(), 10);
            player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
            thorInUseBy = Optional.of(player);
            return setInventory(player, equipment);
        }
        if (thorInUseBy.get().equals(player)){
            thorInUseBy = Optional.empty();
            player.spawnParticle(avenger.getParticle(), player.getLocation(), 10);
            player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
            player.sendMessage("Removing Thor from " + player.getDisplayName());
            return removeInventoryItems(player, avenger.getEquipment());
        }
        thorInUseBy = null;
        player.sendMessage("Thor Already in use.");
        }
        player.sendMessage("Not Op");
        return false;
    }

    public String whoIsThor(){
        if (thorInUseBy.isPresent()){
            return thorInUseBy.get().getDisplayName();
        }
        return "Not in use";
    }

    private boolean setInventory(Player player, Equipment equipment) {
        player.getInventory().setHelmet(equipment.getHelmet());
        player.getInventory().setChestplate(equipment.getChestplate());
        player.getInventory().setLeggings(equipment.getLeggings());
        player.getInventory().setBoots(equipment.getBoots());
        player.getInventory().addItem(equipment.getPrimaryWeapon());
        player.getInventory().addItem(equipment.getSecondaryWeapon());
        return true;
    }

    private boolean removeInventoryItems(Player player, Equipment equipment){
        player.getInventory().remove(equipment.getHelmet().getType());
        player.getInventory().remove(equipment.getChestplate().getType());
        player.getInventory().remove(equipment.getLeggings());
        player.getInventory().remove(equipment.getBoots());
        player.getInventory().remove(equipment.getPrimaryWeapon().getType());
        player.getInventory().remove(equipment.getSecondaryWeapon().getType());
        return true;
    }

    public void unThor() {
        thorInUseBy = Optional.empty();
    }

    public static boolean playerIsCurrentThor(Player player){
        if (thorInUseBy.isPresent()){
            Player thorPlayer = thorInUseBy.get();
            if (player.equals(thorPlayer)){
                return true;
            }
        }
       return false;
    }
}
