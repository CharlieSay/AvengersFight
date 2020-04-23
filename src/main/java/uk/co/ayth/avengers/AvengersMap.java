package uk.co.ayth.avengers;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static boolean playerIsAnAvenger(Player player) {
        return !avengerPlayerWrapperHashMap.values()
                .stream()
                .filter(isPlayerInList(player))
                .collect(Collectors.toList())
                .isEmpty();
    }

    public static List<AvengerEnum> getEnumList(Player player){
       return Arrays.asList(AvengerEnum.values());
    }

    public static Predicate<AvengerPlayerWrapper> isPlayerInList(Player player){
        return avengerPlayerWrapper -> avengerPlayerWrapper.getPlayer().equals(player);
    }
}
