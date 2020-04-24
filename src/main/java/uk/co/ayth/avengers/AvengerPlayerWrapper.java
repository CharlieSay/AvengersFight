package uk.co.ayth.avengers;

import org.bukkit.entity.Player;

public class AvengerPlayerWrapper {

    private Player player;
    private Avenger avenger;

    public AvengerPlayerWrapper(Player player, Avenger avenger) {
        this.player = player;
        this.avenger = avenger;
    }

    public Player getPlayer() {
        return player;
    }

    public Avenger getAvenger() {
        return avenger;
    }

    @Override
    public String toString() {
        return  "Player : " + player.getDisplayName() +
                " | Avenger : " + avenger.getName();
    }
}
