package uk.co.ayth.avengers;

import uk.co.ayth.equipment.HulkEquipment;
import uk.co.ayth.equipment.ThorEquipment;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class AvengersMap {

    private static HashMap<Avenger, Player> avengerPlayerWrapperHashMap;
    private static HashMap<String, Avenger> avengersList;

    static {
        Thor thor = new Thor("Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL);
        Hulk hulk = new Hulk("Hulk, Big Green Man", "hulk", new HulkEquipment(), Particle.DRAGON_BREATH);
        avengersList.put(thor.getName(), thor);
        avengersList.put(hulk.getName(), hulk);
    }

    public static void addAvengerPlayerWrapperToAvengerMap(Player player, Avenger avengerChoice) {
        avengerPlayerWrapperHashMap.put(avengerChoice, player);
    }

    public static boolean isAvengerBeingUsed(Avenger avenger) {
        return avengerPlayerWrapperHashMap.containsKey(avenger);
    }
}
