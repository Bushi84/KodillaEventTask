package com.kodilla.calculator.domain;

public class OutData {

    private double result;
    private String message;

    public OutData(double result, String message) {
        this.result = result;
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
