package de.upb.se.profcalculator;

public class Add {
    private Value leftValue;
    private Value rightValue;

    public Add(Value leftValue, Value rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public String returnExpressionString() {
        return leftValue.toString() + " + " + rightValue.toString();
    }

    public int evaluateExpression() {
        return leftValue.getValue() + rightValue.getValue();
    }

    public String computeEquationRepresentation() {
        return returnExpressionString() + " = " + evaluateExpression();
    }
}
