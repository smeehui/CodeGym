package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayPrimeNumberLowerThanHundred {
    public static void main(String[] args) {
        System.out.println("In ra 20 số nguyên tố đầu tiên");
        int count = 0;
        var isPrime = false;
        Integer[] result = new Integer[]{};
        List<Integer> rsList = new ArrayList<>(Arrays.asList(result));
        int n = 2;
        while (n<100) {
            isPrime = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                rsList.add(n);
            }
            n++;
        }
        result = rsList.toArray(result);
        System.out.println(Arrays.toString(result));
    }
}