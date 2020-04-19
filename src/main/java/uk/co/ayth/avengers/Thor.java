package uk.co.ayth.avengers;

import uk.co.ayth.equipment.Equipment;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

public class Thor extends Avenger {

    public Thor(String displayName, String localisedName, Equipment equipment, Particle particle) {
        super(displayName, localisedName, equipment, particle);
    }

    public boolean checkForMjong(ItemStack itemStack){
        return itemStack.getItemMeta().getLocalizedName().equalsIgnoreCase(this.getEquipment().getPrimaryWeapon().getItemMeta().getLocalizedName());
    }

}
