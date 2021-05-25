package com.kodilla.calculator.event;

import org.springframework.context.ApplicationEvent;

public class CalculatorEvent extends ApplicationEvent  {

    private String operation;

    public CalculatorEvent(Object source, String operation) {
        super(source);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
