package com.mtconsulting.dojo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisTest {

    private Tennis tennis = new Tennis();

    @Test
    public void zero_ZeroShouldBeEqualToLove_Love() {
        assertThat(tennis.printScore(0, 0)).isEqualTo("Love - Love");
    }

    @Test
    public void one_ZeroShouldBeEqualToFifteen_Love() {
        assertThat(tennis.printScore(1, 0)).isEqualTo("Fifteen - Love");
    }

    @Test
    public void two_ZeroShouldBeEqualToThirty_Love() {
        assertThat(tennis.printScore(2, 0)).isEqualTo("Thirty - Love");
    }

    @Test
    public void three_ZeroShouldBeEqualToForty_Love() {
        assertThat(tennis.printScore(3, 0)).isEqualTo("Forty - Love");
    }

    @Test
    public void Zero_OneShouldBeEqualToLove_Fifteen() {
        assertThat(tennis.printScore(0, 1)).isEqualTo("Love - Fifteen");
    }

    @Test
    public void Three_ThreeShouldBeEqualToDeuce() {
        assertThat(tennis.printScore(3, 3)).isEqualTo("Deuce");
    }

    @Test
    public void four_ThreeShouldBeEqualToFirstPlayerAdvantage() {
        assertThat(tennis.printScore(4, 3)).isEqualTo("First Player Advantage");
    }

    @Test
    public void three_FourShouldBeEqualToSecondPlayerAdvantage() {
        assertThat(tennis.printScore(3, 4)).isEqualTo("Second Player Advantage");
    }

    @Test
    public void five_ThreeShouldBeEqualToFirstPlayerAdvantage() {
        assertThat(tennis.printScore(5, 3)).isEqualTo("First Player Wins");
    }

    @Test
    public void four_sixShouldBeEqualToSecondPlayerAdvantage() {
        assertThat(tennis.printScore(4, 6)).isEqualTo("Second Player Wins");
    }


}
