package com.mtconsulting.dojo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class VendingMachineTest {

    private ProductStorage productStorage = mock(ProductStorage.class);
    private CoinCase coinCase = mock(CoinCase.class);
    private VendingMachine machine = new VendingMachine(productStorage, coinCase);

    @Before
    public void init() {
        when(coinCase.returnCoins()).thenReturn(Collections.emptyList());
    }

    @Test
    public void shouldDoNothingIfNoCoinsInsertedAndReturnCoinsActionPerformed() {
        assertThat(machine.coinReturn()).isEqualTo("");
    }

    @Test
    public void shouldDoNothingIfNoCoinsInsertedAndGetAPerformed() {
        assertThat(machine.getA()).isEqualTo("");
    }

    @Test
    public void shouldDoNothingIfNoCoinsInsertedAndGetBPerformed() {
        assertThat(machine.getB()).isEqualTo("");
    }

    @Test
    public void shouldDoNothingIfNoCoinsInsertedAndGetCActionPerformed() {
        assertThat(machine.getC()).isEqualTo("");
    }


    @Test
    public void shouldReturnQuarterIfInsertedAndReturnCoinsActionPerformed() {
        when(coinCase.returnCoins()).thenReturn(Collections.singletonList(Coin.Quarter));

        assertThat(machine.coinReturn()).isEqualTo("Q");
    }

    @Test
    public void shouldGetProductAIfEnoughMoneyInsertedAndGetAActionPerformed() {
        when(productStorage.getProductPrice("A")).thenReturn(.65);
        when(coinCase.isEnoughMoney(.65)).thenReturn(true);

        assertThat(machine.getA()).isEqualTo("A");
    }


    @Test
    public void shouldGetProductBIfEnoughMoneyInsertedAndGetBActionPerformed() {
        when(productStorage.getProductPrice("B")).thenReturn(1.0);
        when(coinCase.isEnoughMoney(1.0)).thenReturn(true);

        assertThat(machine.getB()).isEqualTo("B");
    }

    @Test
    public void shouldGetProductCIfEnoughMoneyInsertedAndGetCActionPerformed() {
        when(productStorage.getProductPrice("C")).thenReturn(1.35);
        when(coinCase.isEnoughMoney(1.35)).thenReturn(true);

        assertThat(machine.getC()).isEqualTo("C");
    }

    @Test
    public void shouldReturnMoneyIfNotEnoughMoneyInsertedAndGetAActionPerformed() {
        List<Coin> coins = Arrays.asList(Coin.Quarter, Coin.Dollar, Coin.Dime);
        when(coinCase.returnCoins()).thenReturn(coins);

        assertThat(machine.getA()).isEqualTo("Q, D, d");
    }

    @Test
    public void shouldReturnProductBAndChangeIfMoreMoneyInsertedAndGetAActionPerformed() {
        when(productStorage.getProductPrice("B")).thenReturn(1.0);
        when(coinCase.isEnoughMoney(1.0)).thenReturn(true);
        when(coinCase.returnCoins()).thenReturn(Collections.singletonList(Coin.Quarter));

        assertThat(machine.getB()).isEqualTo("B, Q");
    }

    @Test
    public void shouldBeAbleToInsertNickel() {
        machine.insertNickel();
        verify(coinCase).insertNickel();
    }

    @Test
    public void shouldBeAbleToInsertDime() {
        machine.insertDime();
        verify(coinCase).insertDime();
    }

    @Test
    public void shouldBeAbleToInsertQuarter() {
        machine.insertQuarter();
        verify(coinCase).insertQuarter();
    }

    @Test
    public void shouldBeAbleToInsertDollar() {
        machine.insertDollar();
        verify(coinCase).insertDollar();
    }
}
