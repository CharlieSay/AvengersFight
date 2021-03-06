package uk.co.ayth.avengers;

import org.bukkit.entity.Player;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static uk.co.ayth.avengers.AvengerEnum.getAvengerEnumByAvenger;

public class AvengersMap {

    private static HashMap<AvengerEnum, AvengerPlayerWrapper> avengerPlayerWrapperHashMap = new HashMap<>();

    public static void emptyHashMap(){
        avengerPlayerWrapperHashMap.clear();
    }

    public static void addAvengerPlayerWrapperToAvengerMap(AvengerEnum avengerEnum, AvengerPlayerWrapper avengerPlayerWrapper) {
        avengerPlayerWrapperHashMap.put(avengerEnum, avengerPlayerWrapper);
    }

    public static boolean removeAvenger(AvengerEnum avengerEnum) {
        return avengerPlayerWrapperHashMap.remove(avengerEnum) != null;
    }

    public static boolean isAvengerBeingUsed(AvengerEnum avenger) {
        return avengerPlayerWrapperHashMap.containsKey(avenger);
    }

    public static boolean isPlayerAvenger(AvengerEnum avengerEnum, Player player){
        AvengerPlayerWrapper avengerPlayerWrapper = avengerPlayerWrapperHashMap.get(avengerEnum);

        if (avengerPlayerWrapper != null){
            return avengerPlayerWrapper.getPlayer().equals(player);
        }
        return false;
    }

    public static List<AvengerPlayerWrapper> getActiveAvengers(){
        return avengerPlayerWrapperHashMap.values().stream().collect(Collectors.toList());
    }

    public static Optional<AvengerEnum> getAvengerEnumByPlayer(Player player){
        for (AvengerPlayerWrapper avengerPlayerWrapper : avengerPlayerWrapperHashMap.values()) {
            if (avengerPlayerWrapper.getPlayer().equals(player)) {
                Avenger avenger = avengerPlayerWrapper.getAvenger();
                return Optional.of(getAvengerEnumByAvenger(avenger));
            }
        }
        return Optional.empty();
    }

    public static boolean playerIsAnAvenger(Player player) {
        return !avengerPlayerWrapperHashMap.values()
                .stream()
                .filter(isPlayerInList(player))
                .collect(Collectors.toList())
                .isEmpty();
    }

    public static List<AvengerEnum> getEnumList(    ){
       return Arrays.asList(AvengerEnum.values());
    }

    public static Predicate<AvengerPlayerWrapper> isPlayerInList(Player player){
        return avengerPlayerWrapper -> avengerPlayerWrapper.getPlayer().equals(player);
    }
}
