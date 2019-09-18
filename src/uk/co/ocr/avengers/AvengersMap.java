package uk.co.ocr.avengers;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.ocr.equipment.HulkEquipment;
import uk.co.ocr.equipment.ThorEquipment;

import java.util.HashMap;
import java.util.Optional;

public class AvengersMap {

    private static HashMap<Avenger, Player> avengerPlayerWrapperHashMap;
    private static HashMap<String, Avenger> avengersList;

    public static void populateAvengersList() {
        Thor thor = new Thor("Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL);
        Hulk hulk = new Hulk("Hulk, Big Green Man", "hulk", new HulkEquipment(), Particle.DRAGON_BREATH);
        avengersList.put(thor.getLocalisedName(), thor);
        avengersList.put(hulk.getLocalisedName(), hulk);
    }

    public static void addAvengerPlayerWrapperToAvengerMap(Player player, Avenger avengerChoice) {
        avengerPlayerWrapperHashMap.put(avengerChoice, player);
    }

//    public static Optional<Avenger> checkIfPlayerIsAnAvenger(Player player){
//        if (avengerPlayerWrapperHashMap.containsValue(player)){
//            return Optional.of(avengerPlayerWrapperHashMap.g)
//        }
//    }

    public static Optional<Avenger> getAvengerByWeapon(ItemMeta itemMeta) {
        String localisedName = itemMeta.getLocalizedName();
        if (avengersList.containsKey(localisedName)) {
            return Optional.of(avengersList.get(localisedName));
        }
        return Optional.empty();
    }

//    public static Optional<AvengerPlayerWrapper> getAvengerPlayerWrapperIfAvengerExists(Avenger avenger) {
//        if (!isAvengerBeingUsed(avenger)) {
//            return Optional.of(avengerPlayerWrapperHashMap.get(avenger));
//        }
//        return Optional.empty();
//    }

    public static boolean isAvengerBeingUsed(Avenger avenger) {
        return avengerPlayerWrapperHashMap.containsKey(avenger);
    }
}
