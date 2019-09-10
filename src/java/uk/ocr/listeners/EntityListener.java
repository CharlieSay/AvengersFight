package uk.ocr.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface EntityListener {

    @EventHandler
    void entityDamageEvent(EntityDamageEvent entityDamageEvent);

    @EventHandler
    void playerUseage(PlayerInteractEvent playerInteractEvent);

}
