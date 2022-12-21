package HackerRankTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println( pageCount(5,4));;
    }
    public static int pageCount(int n, int p) {
        int count1 =0;
        int count2 =0;
        for(int i = 1; i<p;i+=2){
            count1++;
            if(i==p||i==p-1 ) break;
        }
        int last = n%2==0?n+1:n;
        for (int i = last; i > p; i -= 2) {
            if (i==p+1) break;
            count2++;
        }
        return Math.min(count1, count2);
    }

}
