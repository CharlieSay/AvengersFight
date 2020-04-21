package uk.co.ayth.utility;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class TypeChecker {

    public static boolean isPlayer(Entity entity){
        if (!entity.isValid() || !(entity instanceof LivingEntity)){
            return false;
        }
        if (entity instanceof Player){
            return true;
        }
        return false;
    }


}
