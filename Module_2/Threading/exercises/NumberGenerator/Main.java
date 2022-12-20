package NumberGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        NumberGen generator1 = new NumberGen("Gen 1");
//        NumberGen generator2 = new NumberGen("Gen 2");
//        NumberGen generator3 = new NumberGen("Gen 3");
//        Thread t1 = new Thread(generator1);
//        Thread t2 = new Thread(generator2);
//        Thread t3 = new Thread(generator3);
//        t1.start();
//        t2.start();
//        t3.start();
        Integer[] a = {5} ;
        Integer [] b = change(a);
        System.out.println(Arrays.toString(a));
    }

    private static Integer[] change(Integer[] arr) {
        arr = new Integer[]{5,6};
        return arr;
    }
}
