package java.uk.ocr.operators;

import org.bukkit.Color;

import java.util.List;

public abstract class Operator {

    private String operatorDisplayName;
    private OperatorName operatorName;
    private String description;
    private Color colourScheme;
    private OperatorType operatorType;

    public Operator(String operatorDisplayName, OperatorName operatorName, String description, Color colourScheme, OperatorType operatorType) {
        this.operatorDisplayName = operatorDisplayName;
        this.operatorName = operatorName;
        this.description = description;
        this.colourScheme = colourScheme;
        this.operatorType = operatorType;
    }

    public String getOperatorDisplayName() {
        return operatorDisplayName;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public String getDescription() {
        return description;
    }

    public Color getColourScheme() {
        return colourScheme;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}


