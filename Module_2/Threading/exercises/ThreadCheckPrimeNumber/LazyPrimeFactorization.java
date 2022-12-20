package ThreadCheckPrimeNumber;

public class LazyPrimeFactorization  implements Runnable{
    private  int number;

    public LazyPrimeFactorization(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("LazyPrimeFactorization running");
        int count = 0;
        int n = 2;
        boolean isPrime;
        while (count <= number) {
            isPrime = true;
            for (int i = 2; i < n; i++) {
                if (n%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("LZ: times "+ count +": " +n);
                count++;
            }
            n++;
        }
        System.out.println("LazyPrimeFactorization finished");
    }
}
