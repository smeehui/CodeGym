btn.onclick = () => {
    const n = numbers.value;
    let total = "";
    let count = 0;
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) {
            total += i + ",";
            count++;
        }
    }
    result.value = total + `(${count} numbers)`;
};