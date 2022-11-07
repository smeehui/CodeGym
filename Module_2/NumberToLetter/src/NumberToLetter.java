import java.util.Scanner;

public class NumberToLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số cần đọc:");
        int number = sc.nextInt();
        if (number >= 0 && number < 10) System.out.println(lowerThanTen(number));
        else if (number < 20) System.out.println(lowerThanTwenty(number % 10));
        else if (number<1000) System.out.println(higherThanTwenty(number));
        else System.out.println("Out of range");
    }

    private static String higherThanTwenty(int number) {
        String words;
        if (number < 100) {
            words = lowerThanHundreds(number);
            return words;
        }
        int hundreds = number / 100;
        String hundredsLetter = lowerThanTen(hundreds) + " hundreds";
        int absoluteTens = (number % 100);
        String tensLetter;
        if (absoluteTens < 10) {
            tensLetter = lowerThanTen(absoluteTens % 10);
        } else if (absoluteTens < 20) {
            tensLetter = lowerThanTwenty(absoluteTens % 10);
        } else tensLetter = lowerThanHundreds(absoluteTens);
//        String ones = lowerThanTen((number % 100) % 10);
        words = hundredsLetter + " " + tensLetter;
        return words;
    }

    private static String lowerThanHundreds(int number) {
        return tensHigherThan20(number / 10) + " " + lowerThanTen(number % 10);
    }

    private static String tensHigherThan20(int absoluteTens) {
        return switch (absoluteTens) {
            case 0 -> "and";
            case 2 -> "twenty";
            case 3 -> "thirdty";
            case 4 -> "fourty";
            case 5 -> "fifty";
            case 6 -> "sixty";
            case 7 -> "seventy";
            case 8 -> "eighty";
            case 9 -> "ninety";
            default -> "";
        };
    }

    private static String lowerThanTwenty(int number) {
        return switch (number) {
            case 0 -> "ten";
            case 1 -> "eleven";
            case 2 -> "twelve";
            case 3 -> "thirdteen";
            case 4 -> "fourteen";
            case 5 -> "fifteen";
            case 6 -> "sixteen";
            case 7 -> "seventeen";
            case 8 -> "eighteen";
            case 9 -> "nineteen";
            default -> "";
        };
    }

    public static String lowerThanTen(int number) {
        return switch (number) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "night";
            default -> "";
        };
    }
}