package uk.co.ayth.commands;

import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Avenger;
import uk.co.ayth.avengers.AvengerPlayerWrapper;
import uk.co.ayth.avengers.AvengersMap;
import uk.co.ayth.utility.BossbarUtils;

import static uk.co.ayth.avengers.AvengersMap.addAvengerPlayerWrapperToAvengerMap;
import static uk.co.ayth.avengers.AvengersMap.isAvengerBeingUsed;
import static uk.co.ayth.utility.StringUtils.avengersPrefix;

public class ThorCommand extends AvengerCommand {

    @Override
    public boolean makeIntoAvenger(Player player, Avenger avenger) {
        if (player.isOp()) {
            if (!isAvengerBeingUsed(avenger.getAvengerEnum())){
                addAvengerPlayerWrapperToAvengerMap(avenger.getAvengerEnum(), new AvengerPlayerWrapper(player,avenger));
                avenger.becomeAvenger(player);
                BossbarUtils.addBossBar(player, avenger.getDisplayName(), avenger.getBossBarColor());
                player.sendMessage(avengersPrefix() + "youre now " + avenger.getDisplayName());
            }else{
                AvengersMap.removeAvenger(avenger.getAvengerEnum());
                BossbarUtils.resetBossBar();
                avenger.removeAvenger(player);
                player.sendMessage(avengersPrefix() + "youre no longer " + avenger.getDisplayName());
            }
        }
        return false;
    }

    @Override
    public boolean removeAvenger(Player player, Avenger avenger) {
        if (player.isOp()) {
            if (AvengersMap.removeAvenger(avenger.getAvengerEnum())) {
                player.sendMessage(avenger.getDisplayName() + " removed");
                return true;
            } else {
                player.sendMessage(avenger.getDisplayName()+ " not in used first place.");
            }
        }
        return false;
    }
}
