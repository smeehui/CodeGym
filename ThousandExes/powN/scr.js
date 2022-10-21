btn.onclick = () => {
    const n = numbers.value;
    const x = xnumber.value;
    let total = 0;
    for (let i = 1; i <= n; i++) {
        total += i ** 2;
    }
    result.value = total;
};