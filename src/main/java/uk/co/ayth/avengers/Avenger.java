package uk.co.ayth.avengers;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import uk.co.ayth.equipment.Equipment;

public abstract class Avenger {

    private String displayName;
    private String name;
    private Equipment equipment;
    private Particle particle;

    public Avenger(String displayName, String name, Equipment equipment, Particle particle) {
        this.displayName = displayName;
        this.name = name;
        this.equipment = equipment;
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
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

    public abstract void performPrimaryWeapon(Location location);

    public abstract void performSecondaryWeapon();

    public abstract void becomeAvenger(Player player);

    public abstract void removeAvenger(Player player);
}
