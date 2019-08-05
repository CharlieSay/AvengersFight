package uk.ocr.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public interface EntityListener {

    @EventHandler
    void entityDamageEvent(EntityDamageEvent entityDamageEvent);

}
