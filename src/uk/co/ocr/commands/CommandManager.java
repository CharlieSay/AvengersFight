package uk.co.ocr.commands;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ocr.avengers.Hulk;
import uk.co.ocr.equipment.HulkEquipment;
import uk.co.ocr.equipment.ThorEquipment;
import uk.co.ocr.avengers.Thor;

import java.util.logging.Level;

public class CommandManager implements CommandExecutor {

    private MakeAvengerCommand makeAvengerCommand = new MakeAvengerCommand();

    public void performCommand(CommandSender sender, Command command, String label, String[] args) {
        String stringBuild = sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + args.toString();
        try {
            Player player = (Player) sender;
            switch (label) {
                case ("thor"):
                    makePlayerIntoThor(player);
                case ("unthor"):
                    makePlayerIntoThor(player);
                case ("hulk"):
                    makePlayerIntoHulk(player);
                case ("operators"):
                    assignPlayerToAvenger(player, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().log(Level.INFO, ("Non Player tried command : " + e.getMessage().toString()));
        }
        sender.sendMessage(stringBuild);
    }

    private boolean assignPlayerToAvenger(Player player, String[] args) {
        Bukkit.broadcastMessage("YESESEASEYEASE");
        return false;
    }

    private boolean makePlayerIntoThor(Player player) {
        return makeAvengerCommand.makeThorCommand(player,
                new Thor("Thor, Son of Odin", "thor", new ThorEquipment(), Particle.EXPLOSION_NORMAL));
    }

    private boolean makePlayerIntoHulk(Player player) {
        return makeAvengerCommand.makeHulkCommand(player,
                new Hulk("Hulk, Big Massive Dude", "Hulk", new HulkEquipment(), Particle.DRAGON_BREATH));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        performCommand(commandSender, command, label, args);
        return true;
    }
}
