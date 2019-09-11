package uk.co.ocr;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ocr.commands.CommandManager;
import uk.co.ocr.listeners.PlayerListener;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        setUpCommandList(new CommandManager());
        Bukkit.getLogger().log(Level.INFO, "Started");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable(){
        Bukkit.getLogger().log(Level.INFO, "Shutdown");
    }

    private void setUpCommandList(CommandManager commandManager){
        this.getCommand("thor").setExecutor(commandManager);
        this.getCommand("unthor").setExecutor(commandManager);
        this.getCommand("operators").setExecutor(commandManager);
    }
}