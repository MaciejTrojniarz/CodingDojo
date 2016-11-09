package com.mtconsulting.dojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RomanConverterTest {

    private final String romanNumber;
    private final int number;
    private RomanConverter testObject = new RomanConverter();

    @Parameters(name = "{0} <-> {1}")
    public static Object[][] data() {
        return new Object[][]{{1, "I"}, {2, "II"}, {3, "III"}, {5, "V"}, {4, "IV"}, {7, "VII"}, {9, "IX"},
                {10, "X"}, {20, "XX"}, {50, "L"}, {40, "XL"},
                {100, "C"}, {200, "CC"}, {90, "XC"}, {500, "D"}, {400, "CD"}, {1000, "M"},
                {900, "CM"}, {2000, "MM"}, {1999, "MCMXCIX"}};
    }

    public RomanConverterTest(int number, String romanNumber) {
        this.number = number;
        this.romanNumber = romanNumber;
    }

    @Test
    public void shouldConvertNumberToRoman() {
        assertThat(testObject.convert(number)).isEqualTo(romanNumber);
    }

    @Test
    public void shouldConvertRomanToNumber() {
        assertThat(testObject.convert(romanNumber)).isEqualTo(number);
    }
}
