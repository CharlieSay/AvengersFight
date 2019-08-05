package uk.ocr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<Command> commandList;

    public void initiateCommands(){
        commandList = new ArrayList<Command>();
    }

    public void performCommand(CommandSender sender, Command command, String label, String[] args){
        String stringBuild = sender.getName() + " with command : " + command.getName() + " as label : " + label + " and any args : " + args.toString();
        sender.sendMessage(stringBuild);
    }

}
