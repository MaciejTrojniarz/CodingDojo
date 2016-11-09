package com.mtconsulting.dojo;

public class RomanConverter {
    enum RomanNumber {
        M(1000), CM(900), D(500), CD(400), C(100),XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
        final int value;
        RomanNumber(int value){
            this.value = value;
        }
    }

    public String convert(int number) {
        String result = "";
        for(RomanNumber roman : RomanNumber.values()) {
            while(number >= roman.value) {
                result += roman.name();
                number -= roman.value;
            }
        }
        return result;
    }

    public int convert(String romanNumber) {
        int result = 0;
        for(RomanNumber roman : RomanNumber.values()) {
            while(romanNumber.startsWith(roman.name())) {
                result+=roman.value;
                romanNumber = romanNumber.substring(roman.name().length());
            }
        }
        return result;
    }
}
