package uk.co.ayth.commands;

import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Avenger;

public abstract class AvengerCommand {

    public abstract boolean makeIntoAvenger(Player player, Avenger avenger);

    public abstract boolean removeAvenger(Player player, Avenger avenger);

}
