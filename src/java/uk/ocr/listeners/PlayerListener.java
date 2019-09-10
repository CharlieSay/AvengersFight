package uk.ocr.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements EntityListener {

    @EventHandler
    public void entityDamageEvent(EntityDamageEvent entityDamageEvent) {
        entityDamageEvent.setCancelled(true);
    }

    @Override
    public void playerUseage(PlayerInteractEvent playerInteractEvent) {
            playerInteractEvent.setCancelled(true);
        boolean mjong = playerInteractEvent.getItem().getItemMeta().getLocalizedName().equalsIgnoreCase("mjong");
        if (mjong){
            Location location = playerInteractEvent.getClickedBlock().getLocation();

        }
    }

}
