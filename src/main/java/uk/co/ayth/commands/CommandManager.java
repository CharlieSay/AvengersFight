package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Thor;

import java.util.Arrays;
import java.util.logging.Level;

import static uk.co.ayth.utility.BossBarUtils.removeBossBar;

public class CommandManager implements CommandExecutor {

    private ThorCommand avengerCommand = new ThorCommand();

    public void performCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("thor")) {
            makePlayerIntoThor(player);
        }
        if(label.equalsIgnoreCase("removebossbar")){
            removeBossBar();
        }
        Bukkit.getLogger().log(Level.INFO,
                sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + Arrays.toString(args));
    }

    private boolean makePlayerIntoThor(Player player) {
        return avengerCommand.makeIntoAvenger(player, new Thor());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        performCommand(commandSender, command, label, args);
        return true;
    }
}
