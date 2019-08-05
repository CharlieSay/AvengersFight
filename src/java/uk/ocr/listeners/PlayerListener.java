package uk.ocr.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerListener implements EntityListener {

    @EventHandler
    public void entityDamageEvent(EntityDamageEvent entityDamageEvent) {
        entityDamageEvent.setCancelled(true);
    }
}
