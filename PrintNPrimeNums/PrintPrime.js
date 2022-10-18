function countPrime(num) {
    let count = 0;
    let n = 2;
    let arr = [];
    let isPrime = true;
    while (count < num) {
        isPrime = true;
        for (let i = 2; i < n; i++) {
            console.log(i, n);
            if (n % i === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            count++;
            arr.push(n);
        }
        n++;
    }
}
countPrime(9);