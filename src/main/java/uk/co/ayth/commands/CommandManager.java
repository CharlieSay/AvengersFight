package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Hulk;
import uk.co.ayth.avengers.Thor;
import uk.co.ayth.utility.StringUtils;

import java.util.Arrays;
import java.util.logging.Level;

import static uk.co.ayth.avengers.AvengerEnum.getAvengerListAsFormattedString;

public class CommandManager implements CommandExecutor {

    private AvengerCommand avengerCommand = new AvengerCommand();

    private boolean performCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("avenger")) {
            if (!args[0].isEmpty()){
                switch (args[0]){
                    case "thor":
                        return avengerCommand.makeIntoAvenger(player, new Thor());
                    case "hulk":
                        return avengerCommand.makeIntoAvenger(player, new Hulk());
                }
            }
        }
        if (label.equalsIgnoreCase("avengerlist")){
            listOfAvengers(player);
            return true;
        }
        Bukkit.getLogger().log(Level.INFO,
                sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + Arrays.toString(args));
        return false;
    }

    private void listOfAvengers(Player player){
        player.sendMessage(StringUtils.avengersPrefix() + getAvengerListAsFormattedString());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        return performCommand(commandSender, command, label, args);
    }
}
