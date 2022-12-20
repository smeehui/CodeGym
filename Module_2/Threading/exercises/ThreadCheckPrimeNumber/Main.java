package ThreadCheckPrimeNumber;

public class Main {
    public static void main(String[] args) {
        Thread checkPrimeNumberLazy = new Thread(new LazyPrimeFactorization(1000));
        Thread checkPrimeNumberOptimization = new Thread(new OptimizedPrimeFactorization(1000));
        checkPrimeNumberLazy.start();
        checkPrimeNumberOptimization.start();
    }

}
