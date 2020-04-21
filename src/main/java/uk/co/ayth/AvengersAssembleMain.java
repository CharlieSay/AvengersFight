package uk.co.ayth;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ayth.avengers.AvengersMap;
import uk.co.ayth.commands.CommandManager;
import uk.co.ayth.listener.HulkListener;
import uk.co.ayth.listener.ThorListener;

import java.util.logging.Level;

public class AvengersAssembleMain extends JavaPlugin {

    @Override
    public void onEnable() {
        setUpCommandList(new CommandManager());
        Bukkit.getLogger().log(Level.INFO, "Started");
        getServer().getPluginManager().registerEvents(new ThorListener(), this);
        getServer().getPluginManager().registerEvents(new HulkListener(), this);
    }

    @Override
    public void onDisable(){
        AvengersMap.emptyHashMap();
        Bukkit.getLogger().log(Level.INFO, "Shutdown");
    }

    private void setUpCommandList(CommandManager commandManager){
        this.getCommand("thor").setExecutor(commandManager);
        this.getCommand("hulk").setExecutor(commandManager);
    }
}