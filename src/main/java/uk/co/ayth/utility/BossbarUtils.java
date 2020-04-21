package uk.co.ayth.utility;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

public class BossbarUtils {

    public static void addBossBar(Player player, String avengerName, BarColor bossBarColor){
        Bukkit.createBossBar(NamespacedKey.minecraft("avenger"),"You are " + avengerName , bossBarColor, BarStyle.SEGMENTED_12).addPlayer(player);
    }

    public static void resetBossBar(){
        Bukkit.getBossBar(NamespacedKey.minecraft("avenger")).removeAll();
    }


}
