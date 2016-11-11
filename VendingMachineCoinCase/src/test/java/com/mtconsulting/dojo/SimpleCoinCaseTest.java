package com.mtconsulting.dojo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCoinCaseTest {

    private CoinCase coinCase = new SimpleCoinCase();

    @Test
    public void shouldReturnEmptyStringIfNoCashInsertedAndReturnCoinsInvoked() {
        assertThat(coinCase.returnCoins()).isEmpty();
    }

    @Test
    public void shouldReturnDollarIfDollarHasBeenInserted() {
        coinCase.insertDollar();
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Dollar);
    }

    @Test
    public void shouldReturnNickelIfNickelHasBeenInserted() {
        coinCase.insertNickel();
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Nickel);
    }

    @Test
    public void shouldReturnDimeIfDimeHasBeenInserted() {
        coinCase.insertDime();
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Dime);
    }

    @Test
    public void shouldReturnQuarterIfQuarterHasBeenInserted() {
        coinCase.insertQuarter();
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Quarter);
    }

    @Test
    public void shouldReturnAllInsertedCoins() {
        coinCase.insertDollar();
        coinCase.insertDollar();
        coinCase.insertDollar();
        coinCase.insertQuarter();
        coinCase.insertDime();
        coinCase.insertNickel();
        coinCase.insertNickel();
        assertThat(coinCase.returnCoins().stream().filter(coin -> Coin.Dollar.equals(coin)).count()).isEqualTo(3);
        assertThat(coinCase.returnCoins().stream().filter(coin -> Coin.Quarter.equals(coin)).count()).isEqualTo(1);
        assertThat(coinCase.returnCoins().stream().filter(coin -> Coin.Dime.equals(coin)).count()).isEqualTo(1);
        assertThat(coinCase.returnCoins().stream().filter(coin -> Coin.Nickel.equals(coin)).count()).isEqualTo(2);
    }


    @Test
    public void shouldBeNotEnoughToCover1CentAndNoCoinsInserted() {
        assertThat(coinCase.isEnoughMoney(0.01)).isFalse();
    }

    @Test
    public void shouldNickelBeNotEnoughToCover1DollarPrice() {
        coinCase.insertNickel();
        assertThat(coinCase.isEnoughMoney(1.0)).isFalse();
    }

    @Test
    public void shouldDollarBeEnoughToCover1DollarPrice() {
        coinCase.insertDollar();
        assertThat(coinCase.isEnoughMoney(1.0)).isTrue();
    }

    @Test
    public void shouldDollarBeEnoughToCoverHalfDollarPrice() {
        coinCase.insertDollar();
        assertThat(coinCase.isEnoughMoney(0.5)).isTrue();
    }

    @Test
    public void shouldDimeBeEnoughToCover0_01() {
        coinCase.insertDime();
        assertThat(coinCase.isEnoughMoney(0.1)).isTrue();
    }

    @Test
    public void shouldNickelBeEnoughToCover0_05() {
        coinCase.insertNickel();
        assertThat(coinCase.isEnoughMoney(0.05)).isTrue();
    }

    @Test
    public void shouldQuarterBeEnoughToCover0_25() {
        coinCase.insertQuarter();
        assertThat(coinCase.isEnoughMoney(0.25)).isTrue();
    }

    @Test(expected = NotEnoughMoney.class)
    public void shouldThrowNotEnoughMoneyExceptionWhenChargingWithoutInserting() {
        coinCase.charge(1.0);
    }

    @Test
    public void shouldNotReturnMoneyIfDollarInsertedAndDollarCharged() {
        coinCase.insertDollar();
        coinCase.charge(1.0);
        assertThat(coinCase.returnCoins()).isEmpty();
    }

    @Test
    public void shouldNotReturnMoneyIfQuarterInsertedAndQuarterCharged() {
        coinCase.insertQuarter();
        coinCase.charge(.25);
        assertThat(coinCase.returnCoins()).isEmpty();
    }

    @Test
    public void shouldNotReturnMoneyIfDimeInsertedAndDimeCharged() {
        coinCase.insertDime();
        coinCase.charge(.1);
        assertThat(coinCase.returnCoins()).isEmpty();
    }

    @Test
    public void shouldNotReturnMoneyIfNickelInsertedAndNickelCharged() {
        coinCase.insertNickel();
        coinCase.charge(.05);
        assertThat(coinCase.returnCoins()).isEmpty();
    }

    @Test
    public void shouldRemoveDollarWhenNickelAndDollarHaveBeenInsertedAndDollarHaveBeenCharged() {
        coinCase.insertDollar();
        coinCase.insertNickel();
        coinCase.charge(1.0);
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Nickel);
    }

    @Test
    public void shouldRemoveDollarAndAddQuarterWhenDollarHaveBeenInsertedAnd0_75HaveBeenCharged() {
        coinCase.insertDollar();
        coinCase.charge(0.75);
        assertThat(coinCase.returnCoins()).containsOnly(Coin.Quarter);
    }
}
