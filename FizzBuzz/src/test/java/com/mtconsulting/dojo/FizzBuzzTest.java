package com.mtconsulting.dojo;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

    @Test
    @Parameters({"1", "2", "4", "116"})
    public void shouldPrintNumberWhichAreNotMultiples3or5(int number) {
        assertThat(FizzBuzz.convertNumber(number)).isEqualTo(String.valueOf(number));
    }

    @Test
    @Parameters({"3", "6", "9", "24"})
    public void shouldPrintFizzForNumbersMultiples3AndNotMultiples5(int number) {
        assertThat(FizzBuzz.convertNumber(number)).contains("Fizz");
    }

    @Test
    @Parameters({"5", "10", "20", "80"})
    public void shouldPrintBuzzForNumbersMultiples5AndNotMultiples3(int number) {
        assertThat(FizzBuzz.convertNumber(number)).contains("Buzz");
    }

    @Test
    @Parameters({"15", "30", "45", "90"})
    public void shouldPrintFizzBuzzForNumbersMultiples3AndMultiples5(int number) {
        assertThat(FizzBuzz.convertNumber(number)).isEqualTo("FizzBuzz");
    }

    @Test
    @Parameters({"13", "23", "93", "31"})
    public void shouldPrintFizzForNumbersWith3AsAnyDigit(int number) {
        assertThat(FizzBuzz.convertNumber(number)).contains("Fizz");
    }

    @Test
    @Parameters({"51", "152", "501"})
    public void shouldPrintBuzzForNumbersWith5asAnyDigit(int number) {
        assertThat(FizzBuzz.convertNumber(number)).contains("Buzz");
    }

    @Test
    @Parameters({"35", "235", "351", "53"})
    public void shouldPrintFizzBuzzForNumbersWith3And5AsDigits(int number) {
        assertThat(FizzBuzz.convertNumber(number)).isEqualTo("FizzBuzz");
    }
}
