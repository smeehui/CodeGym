const array = [1, 2, 3, 4, 5];
document.getElementById("array").innerHTML = `[${array}]`;

getBtn.onclick = function () {
    let n = Number(inputNumber.value);
    const [number, index] = getIndex(n, array);

    message.innerText =
        index === -1
            ? `${number} không có trong mảng`
            : `Vị trí của ${number} trong mảng là ${index}`;
};

function getIndex(n, array) {
    let index = -1;

    for (let i = 0; i < array.length; i++) {
        if (n === array[i]) {
            index = i;
            break;
        }
    }

    return [n, index];
}
