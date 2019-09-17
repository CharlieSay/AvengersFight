package uk.co.ocr.operators;

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
}
