package uk.ocr.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import uk.ocr.weapons.ThorHammer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CommandManager {

    private List<Command> commandList;

    public void initiateCommands(){
        commandList = new ArrayList<Command>();
    }

    public void performCommand(CommandSender sender, Command command, String label, String[] args){
        String stringBuild = sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + args.toString();
        try{
            Player player = (Player) sender;
            switch (label){
                case ("thor"):
                    makePlayerIntoThor(player);
                case ("unthor"):
                    makePlayerIntoThor(player);
                case ("operators"):
                    assignPlayerToOperator(player,args);
            }
        }catch(Exception e){
            Bukkit.getLogger().log(Level.INFO, "Non Player tried command : {s} : ", sender);
        }
        sender.sendMessage(stringBuild);
    }

    private boolean assignPlayerToOperator(Player player, String[] args){

        return false;
    }

    private boolean makePlayerIntoThor(Player player){
        new MakeThorCommand().makeThorCommand(player);
        return true;
    }


}
