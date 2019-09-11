package java.uk.ocr.operators;

import java.util.HashMap;

public class OperatorMap {

    public static HashMap<OperatorName, Operator> operatorMap;
    public static HashMap<String, OperatorName> convertToOperatorNameMap;

    {
        operatorMap.put(OperatorName.ASH, new Ash());
        convertToOperatorNameMap.put("ash", OperatorName.ASH);
        operatorMap.put(OperatorName.GLAZ, new Glaz());
        convertToOperatorNameMap.put("glaz", OperatorName.GLAZ);
    }

    public static Operator getOperatorObjectByOperatorName(OperatorName operatorName){
        return operatorMap.get(operatorName);
    }

    public static OperatorName getOperatorNameObjectbyString(String operatorNameString){
        return convertToOperatorNameMap.get(operatorNameString);
    }

}
