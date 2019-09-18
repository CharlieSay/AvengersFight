package uk.co.ocr.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import uk.co.ocr.avengers.Avenger;
import uk.co.ocr.avengers.AvengersMap;

import java.util.Optional;

public class PlayerListener implements Listener {

    @EventHandler
    public void entityDamageEvent(EntityDamageByEntityEvent entityDamageEvent) {
        if (entityDamageEvent.getDamager() instanceof Player){
            entityDamageEvent.setCancelled(true);
            Entity entity = entityDamageEvent.getEntity();
            Location location = entity.getLocation();
            createEffect(location);
            Vector vector = location.getDirection().multiply(-1).setY(4);
            vector.multiply(-1).setX(4);
            entity.setVelocity(vector);
        }
    }

    @EventHandler
    public void playerItemUsage(PlayerInteractEvent playerInteractEvent) {
        Optional<Avenger> avenger = checkForWeapon(playerInteractEvent.getItem().getItemMeta());
        if (avenger.isPresent()) {
            playerInteractEvent.setCancelled(true);
            avenger.get().getEquipment().performPrimaryWeapon(playerInteractEvent.getClickedBlock().getLocation());
        }
    }

    private Optional<Avenger> checkForWeapon(ItemMeta itemMeta){
        return AvengersMap.getAvengerByWeapon(itemMeta);
    }

    private void createEffect(Location location) {
        location.getWorld().createExplosion(location, 4f);
        location.getWorld().strikeLightningEffect(location);
        location.getWorld().playEffect(location, Effect.FIREWORK_SHOOT, 1, 1);
        Bukkit.broadcastMessage("THOR USED HIS MJÖLNIR");
    }

}
