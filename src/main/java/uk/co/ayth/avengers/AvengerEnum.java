package uk.co.ayth.avengers;

import java.util.Arrays;

public enum AvengerEnum {

    THOR,
    HULK;

    public static String getAvengerListAsFormattedString(){
        return Arrays.toString(values());
    }
}
