package com.mtconsulting.dojo;

import java.util.List;

public interface CoinCase {
    List<String> returnCoins();

    void charge(double productPrice);

    boolean isEnoughMoney(double requiredAmount);

    void insertQuarter();

    void insertDollar();

    void insertNickel();

    void insertDime();
}
