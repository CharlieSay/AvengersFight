package uk.co.ayth.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import uk.co.ayth.avengers.AvengersMap;

import static uk.co.ayth.avengers.AvengersMap.getEnumList;
import static uk.co.ayth.avengers.AvengersMap.playerIsAnAvenger;
import static uk.co.ayth.utility.BossBarUtils.resetBossBar;

public class GenericListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent playerQuitEvent){
        if (playerIsAnAvenger(playerQuitEvent.getPlayer())){
            getEnumList().stream().forEach(AvengersMap::removeAvenger);
            resetBossBar();
        }
    }
}
