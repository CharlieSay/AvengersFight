package uk.co.ayth.utility;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

public class BossBarUtils {

    public static void addBossBar(Player player, String avengerName, BarColor bossBarColor){
        Bukkit.createBossBar(NamespacedKey.minecraft("avenger"), avengerName, bossBarColor, BarStyle.SOLID).addPlayer(player);
        Bukkit.getBossBar(NamespacedKey.minecraft("avenger")).setProgress(1);
    }

    public static void resetBossBar(){
        Bukkit.getBossBar(NamespacedKey.minecraft("avenger")).removeAll();
    }


}
