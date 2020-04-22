package uk.co.ayth.avengers;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import uk.co.ayth.equipment.Equipment;
import uk.co.ayth.equipment.HulkEquipment;
import static org.bukkit.Particle.*;

public class Hulk extends Avenger{

    public Hulk(){
        super(AvengerEnum.HULK, BarColor.GREEN,"Hulk, genetic mutation", "hulk", new HulkEquipment(), SLIME);
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
}
