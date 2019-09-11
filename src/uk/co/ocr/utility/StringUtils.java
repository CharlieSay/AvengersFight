package uk.co.ocr.utility;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    public static String rainbowString(String stringToRainbow) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ChatColor> colourList = Arrays.asList(ChatColor.RED, ChatColor.BLUE, ChatColor.DARK_GREEN, ChatColor.GREEN, ChatColor.YELLOW, ChatColor.WHITE, ChatColor.LIGHT_PURPLE, ChatColor.GRAY, ChatColor.GOLD);
        for (Character character : stringToRainbow.toCharArray()) {
            ChatColor colour = colourList.get(ThreadLocalRandom.current().nextInt(0, 8));
            stringBuilder.append(colour + character.toString());
        }
        return stringBuilder.toString();
    }

}
