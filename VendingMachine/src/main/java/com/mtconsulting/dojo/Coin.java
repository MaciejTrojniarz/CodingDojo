package com.mtconsulting.dojo;

public enum Coin {
    Dime(0.1, "d"), Nickel(0.05, "N"), Quarter(0.25, "Q"), Dollar(1.0, "D");

    private final double value;
    private final String symbol;

    Coin(double value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public double getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}
