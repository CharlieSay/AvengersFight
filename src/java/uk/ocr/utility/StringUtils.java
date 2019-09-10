package uk.ocr.utility;

import org.bukkit.Color;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    public static String rainbowString(String stringToRainbow) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Color> colourList = Arrays.asList(Color.RED, Color.BLUE, Color.ORANGE, Color.SILVER, Color.FUCHSIA, Color.GREEN, Color.YELLOW, Color.LIME, Color.TEAL);
        for (Character character : stringToRainbow.toCharArray()) {
            Color colour = colourList.get(ThreadLocalRandom.current().nextInt(0, 9 + 1));
            stringBuilder.append(colour + character.toString());
        }
        return stringBuilder.toString();
    }

}
