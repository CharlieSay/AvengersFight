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
        player.getInventory().getHelmet().setAmount(0);
        player.getInventory().getChestplate().setAmount(0);
        player.getInventory().getLeggings().setAmount(0);
        player.getInventory().getBoots().setAmount(0);
        player.getInventory().remove(equipment.getPrimaryWeapon().getType());
        player.getInventory().remove(equipment.getSecondaryWeapon().getType());
    }
}
