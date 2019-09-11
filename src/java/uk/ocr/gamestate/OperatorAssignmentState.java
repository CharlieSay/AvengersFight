package java.uk.ocr.gamestate;

import org.bukkit.entity.Player;

import java.uk.ocr.containers.PlayerOperatorContainer;
import java.uk.ocr.operators.Operator;
import java.uk.ocr.operators.OperatorMap;
import java.util.HashMap;
import java.util.List;

public class OperatorAssignmentState {

    private HashMap<Operator, Boolean> operatorAssignementCheck;
    private List<PlayerOperatorContainer> currentOperatorList;

    public Boolean assignOperator(Player player, String operatorRequestName) {
        Operator operator = OperatorMap.getOperatorObjectByOperatorName(OperatorMap.getOperatorNameObjectbyString(operatorRequestName));
        if (!checkIsOpereatorIsInUse(operator)){
            currentOperatorList.add(new PlayerOperatorContainer(operator,player));
            operatorAssignementCheck.put(operator, true);
            return true;
        }else{
            return false;
        }
    }

    public Boolean unassignOperator(Player player, String operatorRequestName) {
        Operator operator = OperatorMap.getOperatorObjectByOperatorName(OperatorMap.getOperatorNameObjectbyString(operatorRequestName));
        if (checkIsOpereatorIsInUse(operator)){
            operatorAssignementCheck.remove(operator);
            return true;
        }else{
            return false;
        }
    }

    private Boolean checkIsOpereatorIsInUse(Operator operator){
        return (operatorAssignementCheck.containsKey(operator));
    }

}
