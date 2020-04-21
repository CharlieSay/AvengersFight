package uk.co.ayth.utility;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarUtils {

    public static void addBossBar(Player player){
        Bukkit.createBossBar("You are Thor", BarColor.RED, BarStyle.SEGMENTED_12).addPlayer(player);
    }

    public static void removeBossBar(){

    }

}
