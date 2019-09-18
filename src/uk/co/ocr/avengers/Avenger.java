package uk.co.ocr.avengers;

import org.bukkit.Particle;
import uk.co.ocr.equipment.Equipment;

public class Avenger {

    private String displayName;
    private String localisedName;
    private Equipment equipment;
    private Particle particle;

    public Avenger(String displayName, String localisedName, Equipment equipment, Particle particle) {
        this.displayName = displayName;
        this.localisedName = localisedName;
        this.equipment = equipment;
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLocalisedName() {
        return localisedName;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
