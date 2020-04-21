package uk.co.ayth.avengers;

import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import uk.co.ayth.equipment.ThorEquipment;

public class Thor extends Avenger {

    public Thor() {
        super("Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL);
    }

    public boolean checkForMjong(ItemStack itemStack){
        return itemStack.getItemMeta().getLocalizedName().equalsIgnoreCase(this.getEquipment().getPrimaryWeapon().getItemMeta().getLocalizedName());
    }

}
