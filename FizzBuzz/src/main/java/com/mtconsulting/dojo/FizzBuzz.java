package com.mtconsulting.dojo;

import java.util.stream.IntStream;

public class FizzBuzz {

    private static final int FIZZ_NUMBER = 3;
    private static final int BUZZ_NUMBER = 5;
    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";

    public static String convertNumber(int number) {
        String result = "";
        if (isNumberQualifiesToSpecialPrinting(number, FIZZ_NUMBER)) {
            result += FIZZ;
        }
        if (isNumberQualifiesToSpecialPrinting(number, BUZZ_NUMBER)) {
            result += BUZZ;
        }
        if (result.isEmpty()) {
            result = String.valueOf(number);
        }
        return result;
    }

    private static boolean isNumberQualifiesToSpecialPrinting(int number, int specialPrintingDigit) {
        return isDivisibleBy(number, specialPrintingDigit) || containsDigit(number, specialPrintingDigit);
    }

    private static boolean containsDigit(int number, int digit) {
        return String.valueOf(number).contains("" + digit);
    }

    private static boolean isDivisibleBy(int number, int divider) {
        return number % divider == 0;
    }

    private static void printNumber(int number) {
        System.out.println(FizzBuzz.convertNumber(number));
    }


    public static void main(String[] args) {
        IntStream.range(0, 101).forEach(FizzBuzz::printNumber);
    }

}
