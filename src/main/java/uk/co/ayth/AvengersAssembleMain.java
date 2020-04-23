package uk.co.ayth;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ayth.avengers.AvengersMap;
import uk.co.ayth.avengers.Hulk;
import uk.co.ayth.avengers.Thor;
import uk.co.ayth.commands.CommandManager;
import uk.co.ayth.listener.GenericListener;
import uk.co.ayth.listener.HulkListener;
import uk.co.ayth.listener.ThorListener;
import uk.co.ayth.utility.StringUtils;

import java.util.logging.Level;

import static uk.co.ayth.avengers.AvengersMap.emptyHashMap;
import static uk.co.ayth.utility.BossbarUtils.resetBossBar;

public class AvengersAssembleMain extends JavaPlugin {

    @Override
    public void onEnable() {
        setUpCommandList(new CommandManager());
        Bukkit.getLogger().log(Level.INFO, StringUtils.avengersPrefix() + "Started");
        getServer().getPluginManager().registerEvents(new ThorListener(new Thor()), this);
        getServer().getPluginManager().registerEvents(new HulkListener(new Hulk()), this);
        getServer().getPluginManager().registerEvents(new GenericListener(), this);
    }

    @Override
    public void onDisable(){
        emptyHashMap();
        resetBossBar();
        Bukkit.getLogger().log(Level.INFO, StringUtils.avengersPrefix() + "Shutdown");
    }

    private void setUpCommandList(CommandManager commandManager){
        this.getCommand("avenger").setExecutor(commandManager);
        this.getCommand("avengerlist").setExecutor(commandManager);
    }
}