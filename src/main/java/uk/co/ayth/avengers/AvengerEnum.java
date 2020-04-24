package uk.co.ayth.avengers;

import java.util.Arrays;

public enum AvengerEnum {

    THOR,
    HULK;

    public static String getAvengerListAsFormattedString(){
        return Arrays.toString(values());
    }

    public static AvengerEnum getAvengerEnumByAvenger(Avenger avenger){
        for (AvengerEnum value : AvengerEnum.values()) {
             if (value.toString().equalsIgnoreCase(avenger.getName())){
                 return value;
             }
        }
        return null;
    }

    public static Avenger getAvengerByEnum(AvengerEnum avengerEnum){
        if (avengerEnum.toString().equalsIgnoreCase("hulk")){
            return new Hulk();
        }
        if (avengerEnum.toString().equalsIgnoreCase("thor")) {
            return new Thor();
        }
        return null;
    }
}
