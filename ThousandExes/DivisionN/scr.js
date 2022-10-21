btn.onclick = () => {
    const n = numbers.value;
    let total = 0;
    for (let i = 1; i <= n; i++) {
        total += 1 / i;
    }
    result.value = total;
};