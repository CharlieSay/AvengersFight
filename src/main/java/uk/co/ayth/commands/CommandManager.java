package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Thor;

import java.util.Arrays;
import java.util.logging.Level;

public class CommandManager implements CommandExecutor {

    private MakeAvengerCommand makeAvengerCommand = new MakeAvengerCommand();

    public void performCommand(CommandSender sender, Command command, String label, String[] args) {
        String stringBuild = sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + Arrays.toString(args);
        try {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("thor")) {
                makePlayerIntoThor(player);
            } else if (label.equalsIgnoreCase("whoisthor")) {
                whoIsThor(player);
            } else if (label.equalsIgnoreCase("unthorall")) {
                unThorAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().log(Level.INFO, ("Non Player tried command : " + e.getMessage()));
        }
        sender.sendMessage(stringBuild);
    }

    private boolean makePlayerIntoThor(Player player) {
        return makeAvengerCommand.makeThorCommand(player, new Thor());
    }

    private void whoIsThor(Player player) {
        String thorPlayer = makeAvengerCommand.whoIsThor();

        player.sendMessage("Thor player is " + thorPlayer);
    }

    private void unThorAll() {
        makeAvengerCommand.unThor();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        performCommand(commandSender, command, label, args);
        return true;
    }
}
