package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {

    @org.junit.jupiter.api.Test
    void nextDay() {
        int day = 1;
        int month = 1;
        int year = 2018;
        String expected = "2 - 1 - 2018";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }

    ;

    @org.junit.jupiter.api.Test
    void nextLastDayOfMonthOf31Days() {
        int day = 31;
        int month = 1;
        int year = 2018;
        String expected = "1 - 2 - 2018";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void nextLastDayMonthOf30Days() {
        int day = 30;
        int month = 4;
        int year = 2018;
        String expected = "1 - 5 - 2018";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void nextLastDayOfFebruaryInNoneLeapYear() {
        int day = 28;
        int month = 2;
        int year = 2018;
        String expected = "1 - 3 - 2018";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void nextLastDayOfFebruaryInLeapYear() {
        int day = 29;
        int month = 2;
        int year = 2020;
        String expected = "1 - 3 - 2020";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void nextLastDayOfYear() {
        int day = 29;
        int month = 2;
        int year = 2020;
        String expected = "1 - 3 - 2020";
        String result = NextDayCalculator.nextDay(day, month, year);
        assertEquals(expected, result);
    }
}