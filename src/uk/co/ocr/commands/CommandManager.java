package uk.co.ocr.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ocr.equipment.ThorEquipment;
import uk.co.ocr.operators.AvengerPlayerWrapper;
import uk.co.ocr.operators.Thor;

import java.util.logging.Level;

public class CommandManager implements CommandExecutor {

    private MakeThorCommand makeThorCommand = new MakeThorCommand();

    public void performCommand(CommandSender sender, Command command, String label, String[] args) {
        String stringBuild = sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + args.toString();
        try {
            Player player = (Player) sender;
            switch (label) {
                case ("thor"):
                    makePlayerIntoThor(player);
                case ("unthor"):
                    makePlayerIntoThor(player);
                case ("operators"):
                    assignPlayerToOperator(player, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().log(Level.INFO, ("Non Player tried command : "+e.getMessage().toString()));
        }
        sender.sendMessage(stringBuild);
    }

    private boolean assignPlayerToOperator(Player player, String[] args) {
        Bukkit.broadcastMessage("YESESEASEYEASE");
        return false;
    }

    private boolean makePlayerIntoThor(Player player) {
        return makeThorCommand.makeThorCommand(new AvengerPlayerWrapper(player,
                new Thor("Thor, Son of Odin","thor",new ThorEquipment())));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        performCommand(commandSender, command, label, args);
        return true;
    }
}