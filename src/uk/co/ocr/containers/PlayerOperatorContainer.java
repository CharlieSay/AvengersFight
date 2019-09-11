package uk.co.ocr.containers;

import org.bukkit.entity.Player;
import uk.co.ocr.operators.Operator;

public class PlayerOperatorContainer {

    private Operator operator;
    private Player player;

    public PlayerOperatorContainer(Operator operator, Player player) {
        this.operator = operator;
        this.player = player;
    }

    public Operator getOperator() {
        return operator;
    }

    public Player getPlayer() {
        return player;
    }
}
