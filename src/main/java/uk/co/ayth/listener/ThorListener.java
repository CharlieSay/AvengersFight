package uk.co.ayth.listener;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.logging.Level;

import static org.bukkit.Material.AIR;
import static uk.co.ayth.commands.MakeAvengerCommand.playerIsCurrentThor;
import static uk.co.ayth.utility.LocationUtils.getNearbyBlocks;
import static uk.co.ayth.utility.TypeChecker.isPlayer;

public class ThorListener implements Listener {

    @EventHandler
    public void playerFall(EntityDamageEvent entityDamageEvent){
        if (isPlayer(entityDamageEvent.getEntity())){
            Player player = (Player) entityDamageEvent.getEntity();
            entityDamageEvent.setCancelled(true);
            if (playerIsCurrentThor(player)){
                EntityDamageEvent.DamageCause cause = entityDamageEvent.getCause();
                Bukkit.getLogger().log(Level.INFO, "Thor used jump.");
                if (cause.equals(EntityDamageEvent.DamageCause.FALL)){
                    Location location = player.getLocation();
                    player.playSound(location, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 0);
                    player.spawnParticle(Particle.EXPLOSION_HUGE,location,1);
                    List<Block> nearbyBlocks = getNearbyBlocks(location, 1);
                    player.getWorld().strikeLightningEffect(location);
                    for (Block block : nearbyBlocks){
                        block.setType(AIR, true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void playerJump(PlayerInteractEvent playerInteractEvent){
            if (playerIsCurrentThor(playerInteractEvent.getPlayer())){
                if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    Player player = playerInteractEvent.getPlayer();
                    player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 10, 0);
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(4);
                    player.setVelocity(v);
                }
                if (playerInteractEvent.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    performPrimaryWeapon(playerInteractEvent.getPlayer().getLocation());
                }
            }
    }

    private void performPrimaryWeapon(Location location){
        location.getWorld().createExplosion(location, 4f);
        location.getWorld().strikeLightningEffect(location);
        location.getWorld().playEffect(location, Effect.FIREWORK_SHOOT, 1, 1);
    }

}
