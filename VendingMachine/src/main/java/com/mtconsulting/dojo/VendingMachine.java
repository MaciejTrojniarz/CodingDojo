package com.mtconsulting.dojo;

import java.util.stream.Collectors;

public class VendingMachine {
    private static final String PRODUCT_C = "C";
    private static final String PRODUCT_B = "B";
    private static final String PRODUCT_A = "A";
    private final ProductStorage productStorage;
    private final CoinCase coinCase;

    public VendingMachine(ProductStorage productStorage, CoinCase coinCase) {
        this.productStorage = productStorage;
        this.coinCase = coinCase;
    }

    public String coinReturn() {
        String s = coinCase.returnCoins().stream().map(Coin::getSymbol).collect(Collectors.toList()).toString();
        return s.substring(1, s.length() - 1);
    }

    public String getA() {
        return getProductWithChange(PRODUCT_A);
    }

    public String getB() {
        return getProductWithChange(PRODUCT_B);
    }

    public String getC() {
        return getProductWithChange(PRODUCT_C);
    }

    public void insertDollar() {
        coinCase.insertDollar();
    }

    public void insertQuarter() {
        coinCase.insertQuarter();
    }

    public void insertNickel() {
        coinCase.insertNickel();
    }

    public void insertDime() {
        coinCase.insertDime();
    }

    private String getProductWithChange(String productName) {
        double productPrice = productStorage.getProductPrice(productName);
        if (coinCase.isEnoughMoney(productPrice)) {
            coinCase.charge(productPrice);
            return appendWithCoinReturn(productName);
        }
        return coinReturn();
    }

    private String appendWithCoinReturn(String result) {
        String coinReturn = coinReturn();
        if (coinReturn.length() != 0) {
            result += ", ";
        }
        return result + coinReturn;
    }
}
