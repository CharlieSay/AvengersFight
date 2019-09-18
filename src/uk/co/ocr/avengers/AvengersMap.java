package uk.co.ocr.avengers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Optional;

public class AvengersMap {

    private static HashMap<Avenger, AvengerPlayerWrapper> avengerPlayerWrapperHashMap;

    public static void addAvengerPlayerWrapperToAvengerMap(Player player, Avenger avengerChoice) {
        AvengerPlayerWrapper avengerPlayerWrapper = new AvengerPlayerWrapper(player, avengerChoice);
        avengerPlayerWrapperHashMap.put(avengerChoice, avengerPlayerWrapper);
    }

    public static Optional<AvengerPlayerWrapper> getAvengerPlayerWrapperIfAvengerExists(Avenger avenger) {
        if (isAvengerBeingUsed(avenger)) {
            return Optional.of(avengerPlayerWrapperHashMap.get(avengerPlayerWrapperHashMap));
        }
        return Optional.empty();
    }

    public static boolean isAvengerBeingUsed(Avenger avenger) {
        return avengerPlayerWrapperHashMap.containsKey(avenger);
    }
}
