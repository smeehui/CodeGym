package ThreadCheckPrimeNumber;

public class OptimizedPrimeFactorization implements Runnable{
    private int number;

    public OptimizedPrimeFactorization(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("OptimizedPrimeFactorization running");
        int count = 0;
        int n = 2;
        boolean isPrime;
        while (count <= number) {
            isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Opt: times "+ count +": " +n);
                count++;
            }
            n++;
        }
        System.out.println("OptimizedPrimeFactorization finished");
    }
}
