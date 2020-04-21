package uk.co.ayth.listener;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import uk.co.ayth.avengers.AvengerEnum;
import uk.co.ayth.avengers.Hulk;
import uk.co.ayth.avengers.Thor;

import static uk.co.ayth.avengers.AvengersMap.*;
import static uk.co.ayth.utility.TypeChecker.isPlayer;

public class HulkListener implements Listener {

    @EventHandler
    public void playerJump(PlayerInteractEvent playerInteractEvent) {
        if (isAllowedToUse(playerInteractEvent.getPlayer())) {
            if (isAvengerBeingUsed(AvengerEnum.HULK) && isPlayerHulk(playerInteractEvent.getPlayer())) {
                Player player = playerInteractEvent.getPlayer();
                if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR) && player.isOnGround()) {
                    player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 10, 0);
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(3);
                    player.setVelocity(v);
                }
                if (playerInteractEvent.getAction().equals(Action.LEFT_CLICK_BLOCK)
                        || playerInteractEvent.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    performPrimaryWeapon(playerInteractEvent.getPlayer().getLocation());
                }
            }
        }
    }

    @EventHandler
    public void playerFall(EntityDamageEvent entityDamageEvent) {
        if (isPlayer(entityDamageEvent.getEntity())) {
            Player player = (Player) entityDamageEvent.getEntity();
            if (isAllowedToUse(player)) {
                if (isAvengerBeingUsed(AvengerEnum.HULK) && isPlayerHulk(player)) {
                    entityDamageEvent.setCancelled(true);
                    EntityDamageEvent.DamageCause cause = entityDamageEvent.getCause();
                    if (cause.equals(EntityDamageEvent.DamageCause.FALL)) {
                        new Thor().performThorFall(player);
                    }
                }
            }
        }
    }

    private boolean isAllowedToUse(Player player){
        return player.isOp() && playerIsAnAvenger(player);
    }

    private void performPrimaryWeapon(Location location) {
        new Hulk().performPrimaryWeapon(location);
    }

}
