package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Hulk;
import uk.co.ayth.avengers.Thor;

import java.util.Arrays;
import java.util.logging.Level;

public class CommandManager implements CommandExecutor {

    public void performCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("thor")) {
            makePlayerIntoThor(player);
        }
        if (label.equalsIgnoreCase("hulk")) {
            makePlayerIntoHulk(player);
        }
        Bukkit.getLogger().log(Level.INFO,
                sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + Arrays.toString(args));
    }

    private boolean makePlayerIntoThor(Player player) {
        ThorCommand avengerCommand = new ThorCommand();
        return avengerCommand.makeIntoAvenger(player, new Thor());
    }

    private boolean makePlayerIntoHulk(Player player){
        ThorCommand avengerCommand = new ThorCommand();
        return avengerCommand.makeIntoAvenger(player, new Hulk());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        performCommand(commandSender, command, label, args);
        return true;
    }
}
