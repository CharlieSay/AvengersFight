package uk.co.ayth.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import uk.co.ayth.avengers.AvengerEnum;
import uk.co.ayth.avengers.Thor;

import static uk.co.ayth.avengers.AvengersMap.*;
import static uk.co.ayth.utility.TypeChecker.isPlayer;

public class ThorListener implements Listener {

    private Thor thor;
    private AvengerEnum avengerEnum;

    public ThorListener(Thor thor) {
        this.thor = thor;
        avengerEnum = AvengerEnum.THOR;
    }

    @EventHandler
    public void playerJump(PlayerInteractEvent playerInteractEvent) {
        Player player = playerInteractEvent.getPlayer();
        if (isAllowedToUse(player, avengerEnum)) {
            Action action = playerInteractEvent.getAction();
            if (action.equals(Action.RIGHT_CLICK_AIR) && player.isOnGround()) {
                thor.performThorJump(player);
            }
            if (action.equals(Action.LEFT_CLICK_BLOCK)) {
                thor.performPrimaryWeapon(player.getLocation());
            }
        }
    }

    @EventHandler
    public void playerFall(EntityDamageEvent entityDamageEvent) {
        if (isPlayer(entityDamageEvent.getEntity())) {
            Player player = (Player) entityDamageEvent.getEntity();
            if (isAllowedToUse(player, avengerEnum)) {
                if (entityDamageEvent.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                    entityDamageEvent.setCancelled(true);
                    thor.performThorFall(player);
                }
            }
        }
    }

    private boolean isAllowedToUse(Player player, AvengerEnum avengerEnum) {
        return player.isOp() && playerIsAnAvenger(player) && isAvengerBeingUsed(avengerEnum) && isPlayerAvenger(avengerEnum, player);
    }

}
