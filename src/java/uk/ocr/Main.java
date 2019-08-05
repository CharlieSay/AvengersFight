package uk.ocr;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import uk.ocr.commands.CommandManager;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    private CommandManager commandManager;

    @Override
    public void onEnable() {
        commandManager = new CommandManager();
        Bukkit.getLogger().log(Level.INFO, "Started");
    }

    @Override
    public void onDisable(){
        Bukkit.getLogger().log(Level.INFO, "Shutdown");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        commandManager.performCommand(sender,command,label,args);
        return true;
    }

}