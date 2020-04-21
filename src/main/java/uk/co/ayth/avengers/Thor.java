package uk.co.ayth.avengers;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import uk.co.ayth.equipment.Equipment;
import uk.co.ayth.equipment.ThorEquipment;

import java.util.List;

import static org.bukkit.Material.AIR;
import static uk.co.ayth.utility.LocationUtils.getNearbyBlocks;

public class Thor extends Avenger {

    public Thor() {
        super("Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL);
    }

    @Override
    public void performPrimaryWeapon(Location location) {
        location.getWorld().strikeLightningEffect(location);
        location.getWorld().playEffect(location, Effect.FIREWORK_SHOOT, 1, 1);
    }

    @Override
    public void performSecondaryWeapon() {

    }

    @Override
    public void becomeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.sendTitle((ChatColor.RED + "You are now Thor"), "Use the Mjölnir wisely.", 20, 100, 20);
        player.spawnParticle(super.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
        player.getInventory().setHelmet(equipment.getHelmet());
        player.getInventory().setChestplate(equipment.getChestplate());
        player.getInventory().setLeggings(equipment.getLeggings());
        player.getInventory().setBoots(equipment.getBoots());
        player.getInventory().addItem(equipment.getPrimaryWeapon());
        player.getInventory().addItem(equipment.getSecondaryWeapon());
    }

    @Override
    public void removeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.spawnParticle(this.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
        player.getInventory().remove(equipment.getHelmet().getType());
        player.getInventory().remove(equipment.getChestplate().getType());
        player.getInventory().remove(equipment.getLeggings());
        player.getInventory().remove(equipment.getBoots());
        player.getInventory().remove(equipment.getPrimaryWeapon().getType());
        player.getInventory().remove(equipment.getSecondaryWeapon().getType());
    }

    public void performThorFall(Player player){
        Location location = player.getLocation();
        player.playSound(location, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 0);
        player.spawnParticle(Particle.EXPLOSION_HUGE,location,1);

        List<Block> nearbyBlocks = getNearbyBlocks(location, 2);
        player.getWorld().strikeLightningEffect(location);
        for (Block block : nearbyBlocks){
            block.setType(AIR, true);
        }
    }
}
