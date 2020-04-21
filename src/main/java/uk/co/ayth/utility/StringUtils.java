package uk.co.ayth.utility;

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
            stringBuilder.append(colour).append(character.toString());
        }
        return stringBuilder.toString();
    }

    public static String avengersPrefix(){
        ChatColor darkBlue = ChatColor.DARK_BLUE;
        ChatColor silver = ChatColor.GRAY;
        String startBox = silver + "[";
        String middleContent = darkBlue + "AvengersAssemble";
        String endBox = silver + "] ";
        return startBox + middleContent + endBox;
    }

}
