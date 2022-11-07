function giaiPtBacHai(a, b, c) {
    console.log(`Tính nghiệm phương trình ${a}x^2 + ${b}x + ${c} = 0`);
    if (a === 0) {
        if (c == 0 && b == 0) {
            console.log("PT có vô số nghiệm");
            return;
        }
        if (b == 0 && c != 0) {
            console.log("PT vô nghiệm");
            return;
        }
        console.log(`PT có nghiệm là ${-c / b}`);
        return;
    }
    if (a != 0) {
        let delt = b * b - 4 * a * c;
        switch (true) {
            case delt == 0:
                console.log(`Phương trình có nghiệm kép${-b / (2 * a)}`);
                break;
            case delt < 0:
                console.log("Phương trình vô nghiệm");
                break;
            default:
                let nghiem1 = (-b + Math.sqrt(delt)) / (2 * a);
                let nghiem2 = (-b - Math.sqrt(delt)) / (2 * a);
                console.log(
                    `Phương trình có 2 nghiêm x1 = ${nghiem1} x2 = ${nghiem2}`,
                );
                break;
        }
    }
}
giaiPtBacHai(4, 4, 3);