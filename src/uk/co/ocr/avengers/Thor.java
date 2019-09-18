package uk.co.ocr.avengers;

import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import uk.co.ocr.equipment.Equipment;

public class Thor extends Avenger {

    public Thor(String displayName, String localisedName, Equipment equipment, Particle particle) {
        super(displayName, localisedName, equipment, particle);
    }

    public boolean checkForMjong(ItemStack itemStack){
        return itemStack.getItemMeta().getLocalizedName() == this.getEquipment().getPrimaryWeapon().getItemMeta().getLocalizedName();
    }

}
