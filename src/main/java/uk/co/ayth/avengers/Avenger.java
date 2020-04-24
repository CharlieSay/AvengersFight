package uk.co.ayth.avengers;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import uk.co.ayth.equipment.Equipment;

public abstract class Avenger {

    private AvengerEnum avengerEnum;
    private BarColor bossBarColor;
    private String displayName;
    private String name;
    private Equipment equipment;
    private Particle particle;
    private int jumpHeight;

    public Avenger(AvengerEnum avengerEnum, BarColor bossBarColor, String displayName, String name, Equipment equipment, Particle particle, int jumpHeight) {
        this.avengerEnum = avengerEnum;
        this.bossBarColor = bossBarColor;
        this.displayName = displayName;
        this.name = name;
        this.equipment = equipment;
        this.particle = particle;
        this.jumpHeight = jumpHeight;
    }

    public AvengerEnum getAvengerEnum() {
        return avengerEnum;
    }

    public BarColor getBossBarColor() {
        return bossBarColor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Particle getParticle() {
        return particle;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public abstract void performPrimaryWeapon(Location location);

    public abstract void performSecondaryWeapon();

    public void performJump(Player player){}

    public void performFall(Player player){}

    public abstract void becomeAvenger(Player player);

    public abstract void removeAvenger(Player player);

    public void becomeAvengerSet(Player player, Equipment equipment) {
        player.getInventory().setHelmet(equipment.getHelmet());
        player.getInventory().setChestplate(equipment.getChestplate());
        player.getInventory().setLeggings(equipment.getLeggings());
        player.getInventory().setBoots(equipment.getBoots());
        player.getInventory().addItem(equipment.getPrimaryWeapon());
        player.getInventory().addItem(equipment.getSecondaryWeapon());
    }

    public void removeAvengerSet(Player player, Equipment equipment) {
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
        player.getInventory().remove(equipment.getPrimaryWeapon().getType());
        player.getInventory().remove(equipment.getSecondaryWeapon().getType());
    }
}
