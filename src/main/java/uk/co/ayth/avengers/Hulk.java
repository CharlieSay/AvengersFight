package uk.co.ayth.avengers;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import uk.co.ayth.equipment.Equipment;
import uk.co.ayth.equipment.HulkEquipment;

import java.util.List;

import static org.bukkit.Material.AIR;
import static org.bukkit.Particle.*;
import static uk.co.ayth.utility.LocationUtils.getNearbyBlocks;

public class Hulk extends Avenger {

    public Hulk(){
        super(AvengerEnum.HULK, BarColor.GREEN,"Hulk, genetic mutation", "hulk", new HulkEquipment(), SLIME, 3);
    }

    @Override
    public void performPrimaryWeapon(Location location) {
        location.getWorld().playEffect(location, Effect.DRAGON_BREATH, 1, 1);
    }

    @Override
    public void performSecondaryWeapon() {

    }

    @Override
    public void becomeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.sendTitle((ChatColor.GREEN + "You are now " + this.getName()), "Use your fists wisely.", 20, 100, 20);
        player.spawnParticle(super.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
        becomeAvengerSet(player, equipment);
    }

    @Override
    public void removeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.spawnParticle(this.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.ENTITY_RAVAGER_ROAR, 1, 0);
        removeAvengerSet(player, equipment);
    }

    @Override
    public void performFall(Player player) {
        Location location = player.getLocation();
        player.playSound(location, Sound.BLOCK_IRON_TRAPDOOR_OPEN, 1, 0);
        player.spawnParticle(CAMPFIRE_SIGNAL_SMOKE,location,1);

        List<Block> nearbyBlocks = getNearbyBlocks(location, 2);
        for (Block block : nearbyBlocks){
            if (block.getType().equals(Material.GRASS_BLOCK)){
                block.setType(Material.DIRT);
            }else{
                block.setType(AIR, true);
            }
        }
    }

    @Override
    public void performJump(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_BAMBOO_STEP, 10, 0);
        Vector v = player.getLocation().getDirection().multiply(-1).setY(getJumpHeight());
        player.setVelocity(v);
    }
}
