package uk.co.ocr.avengers;

import uk.co.ocr.equipment.Equipment;

public class Avenger {

    private String displayName;
    private String localisedName;
    private Equipment equipment;

    public Avenger(String displayName, String localisedName, Equipment equipment) {
        this.displayName = displayName;
        this.localisedName = localisedName;
        this.equipment = equipment;
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
