package org.example;

public class NextDayCalculator {
    public static String nextDay(int date, int month, int year) {
        int nextDay = date + 1;
        int nextMonth = month;
        int maxDayOfMonth = getMaxDayOfMonth(month);
        int nextYear = year;
        if (nextDay > maxDayOfMonth) {
            boolean isLeapYear = isLeapYear(year);
            if (isLeapYear && month == 2) {
                nextDay = nextDay > 29 ? 1 : 29;
                nextMonth = nextDay ==1 ? 3 : 2;
            } else {
                nextDay = 1;
                nextMonth++;
            }
            if (nextMonth == 13) {
                nextMonth = 1;
                nextYear++;
            }
        }
        return nextDay + " - " + nextMonth + " - " + nextYear;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) return true;
            return year % 400 == 0;
        }
        return false;
    }

    private static int getMaxDayOfMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }

    public static void main(String[] args) {
    }
}