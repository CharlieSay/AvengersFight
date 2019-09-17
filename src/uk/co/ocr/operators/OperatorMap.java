package uk.co.ocr.operators;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class OperatorMap {

    private static HashMap<Player, AvengerPlayerWrapper> avengerPlayerWrapperHashMap;

    public static void addPlayerToAvengerMap(Player player, Avenger avengerChoice){
        AvengerPlayerWrapper avengerPlayerWrapper = new AvengerPlayerWrapper(player,avengerChoice);
        avengerPlayerWrapperHashMap.put(player,avengerPlayerWrapper);
    }

    public static boolean getAvengerPlayerWrapperIfPlayerExists(Player player){
        AvengerPlayerWrapper avengerPlayerWrapper = avengerPlayerWrapperHashMap.get(player);
        if (avengerPlayerWrapper != null){
            return true;
        }
        return false;
    }

}
