package com.kodilla.calculator.domain;

public class InData {

    private double firstNumber;
    private double secondNumber;

    public InData(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }
}
