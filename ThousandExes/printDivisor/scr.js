btn.onclick = () => {
    const n = numbers.value;
    let total = "";
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) {
            total += i + ",";
        }
    }
    result.value = total;
};