btn.onclick = () => {
    const n = numbers.value;
    let total = 0;

    for (let i = 1; i <= n; i++) {
        total += mult(i);
    }
    result.value = total;
};

function mult(num) {
    let count = 1;
    let result = 1;

    while (count <= num) {
        result *= count;
        count++;
    }
    return result;
}