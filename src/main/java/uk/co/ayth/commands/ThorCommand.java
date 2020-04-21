package uk.co.ayth.commands;

import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Avenger;
import uk.co.ayth.avengers.AvengerEnum;
import uk.co.ayth.avengers.AvengerPlayerWrapper;
import uk.co.ayth.avengers.AvengersMap;
import uk.co.ayth.utility.BossBarUtils;


import static uk.co.ayth.avengers.AvengersMap.addAvengerPlayerWrapperToAvengerMap;
import static uk.co.ayth.avengers.AvengersMap.isAvengerBeingUsed;
import static uk.co.ayth.utility.StringUtils.avengersPrefix;

public class ThorCommand extends AvengerCommand {

    @Override
    public boolean makeIntoAvenger(Player player, Avenger avenger) {
        if (player.isOp()) {
            if (!isAvengerBeingUsed(AvengerEnum.THOR)){
                addAvengerPlayerWrapperToAvengerMap(AvengerEnum.THOR, new AvengerPlayerWrapper(player,avenger));
                avenger.becomeAvenger(player);
                BossBarUtils.addBossBar(player);
                player.sendMessage(avengersPrefix() + "youre now thor");
            }else{
                AvengersMap.removeAvenger(AvengerEnum.THOR);
                avenger.removeAvenger(player);
                BossBarUtils.removeBossBar();
                player.sendMessage(avengersPrefix() + "youre no longer thor");
            }
        }
        return false;
    }

    @Override
    public boolean removeAvenger(Player player, Avenger avenger) {
        if (player.isOp()) {
            if (AvengersMap.removeAvenger(AvengerEnum.THOR)) {
                player.sendMessage("thor removed");
                return true;
            } else {
                player.sendMessage("Thor not in used first place.");
            }
        }
        return false;
    }
}
