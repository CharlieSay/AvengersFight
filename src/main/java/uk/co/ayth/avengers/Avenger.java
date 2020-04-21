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

    public Avenger(AvengerEnum avengerEnum, BarColor bossBarColor, String displayName, String name, Equipment equipment, Particle particle) {
        this.avengerEnum = avengerEnum;
        this.bossBarColor = bossBarColor;
        this.displayName = displayName;
        this.name = name;
        this.equipment = equipment;
        this.particle = particle;
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

    public abstract void performPrimaryWeapon(Location location);

    public abstract void performSecondaryWeapon();

    public abstract void becomeAvenger(Player player);

    public abstract void removeAvenger(Player player);
}
