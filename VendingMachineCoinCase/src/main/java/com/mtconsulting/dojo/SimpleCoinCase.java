package com.mtconsulting.dojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SimpleCoinCase implements CoinCase {

    private final List<Coin> insertedCoins = new ArrayList<>();

    @Override
    public List<Coin> returnCoins() {
        return new ArrayList<>(insertedCoins);
    }

    @Override
    public void charge(double chargeAmount) {
        if (!isEnoughMoney(chargeAmount))
            throw new NotEnoughMoney();
        final List<Coin> charged = new ArrayList<>();
        List<Coin> coinsToSort = this.insertedCoins;
        sortCoinsInDescOrder(coinsToSort);
        Iterator<Coin> coinIterator = this.insertedCoins.iterator();
        while (chargeAmount > 0 && coinIterator.hasNext()) {
            Coin coin = coinIterator.next();
            charged.add(coin);
            chargeAmount -= coin.getValue();
        }
        this.insertedCoins.removeAll(charged);
        if (chargeAmount < 0) {
            this.insertedCoins.addAll(missingCoins(-chargeAmount));
        }
    }

    private void sortCoinsInDescOrder(List<Coin> coinsToSort) {
        Collections.sort(coinsToSort, (o1, o2) -> -Double.compare(o1.getValue(), o2.getValue()));
    }

    private List<Coin> missingCoins(double amount) {
        List<Coin> fillInCoins = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        Collections.addAll(coins, Coin.values());
        sortCoinsInDescOrder(coins);
        for (Coin coin : coins) {
            if (amount >= coin.getValue()) {
                fillInCoins.add(coin);
                amount -= coin.getValue();
            }
        }
        return fillInCoins;
    }

    @Override
    public boolean isEnoughMoney(double requiredAmount) {
        return requiredAmount <= getCurrentAmount();
    }

    private double getCurrentAmount() {
        return getSumOfCoins(insertedCoins);
    }

    private double getSumOfCoins(List<Coin> insertedCoins) {
        return insertedCoins.stream().mapToDouble(Coin::getValue).sum();
    }

    @Override
    public void insertQuarter() {
        insertedCoins.add(Coin.Quarter);
    }

    @Override
    public void insertDollar() {
        insertedCoins.add(Coin.Dollar);
    }

    @Override
    public void insertNickel() {
        insertedCoins.add(Coin.Nickel);
    }

    @Override
    public void insertDime() {
        insertedCoins.add(Coin.Dime);
    }
}
