btn.onclick = () => {
    const n = numbers.value;
    const x = xnumbers.value;
    let total = 1;
    const facrotial = (a) => {
        let result = 1;
        let i = 1;
        while (i <= a) {
            result *= i;
            i++;
        }
        return result;
    };
    for (let i = 0; i <= n; i++) {
        total += x ** (2 * i + 1) / facrotial(2 * i + 1);
    }
    result.value = total;
};