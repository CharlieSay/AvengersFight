package uk.co.ayth.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import uk.co.ayth.avengers.Avenger;
import uk.co.ayth.avengers.AvengerEnum;
import uk.co.ayth.avengers.AvengerPlayerWrapper;
import uk.co.ayth.avengers.AvengersMap;
import uk.co.ayth.utility.BossbarUtils;

import java.util.Optional;

import static uk.co.ayth.avengers.AvengersMap.addAvengerPlayerWrapperToAvengerMap;
import static uk.co.ayth.avengers.AvengersMap.isAvengerBeingUsed;
import static uk.co.ayth.utility.StringUtils.avengersPrefix;

public class AvengerCommand {

    public boolean makeIntoAvenger(Player player, Avenger avenger) {
        if (player.isOp()) {
            if (!isAvengerBeingUsed(avenger.getAvengerEnum())){
                addAvengerPlayerWrapperToAvengerMap(avenger.getAvengerEnum(), new AvengerPlayerWrapper(player,avenger));
                avenger.becomeAvenger(player);
                BossbarUtils.addBossBar(player, avenger.getDisplayName(), avenger.getBossBarColor());
                player.sendMessage(avengersPrefix() + avenger.getDisplayName() + " equipped.");
            }else{
                return deleteAvengerData(avenger.getDisplayName(), avenger, player);
            }
            return true;
        }
        return false;
    }

    public boolean removeAvenger(String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        if (player.isOp()) {
            Optional<AvengerEnum> avengerEnumByPlayer = AvengersMap.getAvengerEnumByPlayer(player);
            if (avengerEnumByPlayer.isPresent()){
                return deleteAvengerData(avengerEnumByPlayer.get().toString(), AvengerEnum.getAvengerByEnum(avengerEnumByPlayer.get()), player);
            }
            player.sendMessage(avengersPrefix() +  player.getDisplayName() +" wasn't an avenger");
        }
        return false;
    }

    private boolean deleteAvengerData(String string, Avenger avenger, Player player){
        BossbarUtils.resetBossBar();
        avenger.removeAvenger(player);
        player.sendMessage(avengersPrefix() + string + " removed.");
        return AvengersMap.removeAvenger(avenger.getAvengerEnum());
    }
}
