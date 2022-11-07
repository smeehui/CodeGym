calcBtn.onclick = function () {
    let a = Number(document.querySelector("#inputA").value);
    let b = Number(document.querySelector("#inputB").value);
    let c = Number(document.querySelector("#inputC").value);
    message.innerHTML = giaiPhuongTrinh(a, b, c);
};
function giaiPhuongTrinh(a, b, c) {
    let phuongTrinh = `${a}x2 + ${b}x + ${c} = 0`;
    let result;
    if (a === 0) {
        if (c == 0 && b == 0) {
            return `Phương trình ${phuongTrinh} có vô số nghiệm`;
        }
        if (b == 0 && c != 0) {
            return `Phương trình ${phuongTrinh} vô nghiệm`;
        }
        return `Phương trình ${phuongTrinh} có nghiệm là ${-c / b}`;
    }
    if (a != 0) {
        let delta = b * b - 4 * a * c;
        switch (true) {
            case delta == 0:
                result = `Phương trình ${phuongTrinh} có nghiệm kép ${
                    -b / (2 * a)
                }`;
                break;
            case delta < 0:
                result = `Phương trình ${phuongTrinh} vô nghiệm`;
                break;
            default:
                let nghiem1 = (-b + Math.sqrt(delta)) / (2 * a);
                let nghiem2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = `Phương trình ${phuongTrinh} có 2 nghiệm <br> x1 = ${nghiem1} <br> x2 = ${nghiem2}`;
                break;
        }
    }
    return result;
}
