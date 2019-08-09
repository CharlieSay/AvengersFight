package uk.ocr.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
            assignPlayerToOperator(player,args);
        }catch(Exception e){
            Bukkit.getLogger().log(Level.INFO, "Non Player tried command : {s} : ", sender);
        }
        sender.sendMessage(stringBuild);
    }

    private boolean assignPlayerToOperator(Player player, String[] args){

        return false;
    }

}
