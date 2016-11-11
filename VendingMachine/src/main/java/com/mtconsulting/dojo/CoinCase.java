package com.mtconsulting.dojo;

import java.util.List;

public interface CoinCase {
    List<Coin> returnCoins();

    void charge(double chargeAmount);

    boolean isEnoughMoney(double requiredAmount);

    void insertQuarter();

    void insertDollar();

    void insertNickel();

    void insertDime();

}
