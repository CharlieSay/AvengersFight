package uk.co.ayth.avengers;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import uk.co.ayth.equipment.Equipment;
import uk.co.ayth.equipment.ThorEquipment;

import java.util.List;

import static org.bukkit.Material.AIR;
import static uk.co.ayth.utility.LocationUtils.getNearbyBlocks;

public class Thor extends Avenger {

    public Thor() {
        super(AvengerEnum.THOR, BarColor.RED,"Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL);
    }

    @Override
    public void performPrimaryWeapon(Location location) {
        location.getWorld().strikeLightningEffect(location);
    }

    @Override
    public void performSecondaryWeapon() {

    }

    @Override
    public void becomeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.sendTitle((ChatColor.RED + "You are now Thor"), "Use the Mjölnir wisely.", 20, 100, 20);
        player.spawnParticle(super.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.BLOCK_METAL_STEP, 1, 0);
        becomeAvengerSet(player, equipment);
    }

    @Override
    public void removeAvenger(Player player) {
        Equipment equipment = super.getEquipment();
        player.spawnParticle(this.getParticle(), player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.BLOCK_METAL_STEP, 1, 0);
        removeAvengerSet(player, equipment);
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

    public void performThorJump(Player player){
        player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 10, 0);
        Vector v = player.getLocation().getDirection().multiply(-1).setY(4);
        player.setVelocity(v);
    }
}
