function isTriangle(a, b, c) {
    if (a > 0 && b > 0 && c > 0) {
        if (a + b > c && b + c > a && a + c > b) {
            console.log("Là một tam giác");
            return;
        }
        console.log("Không phải một tam giác");
        return;
    }
    console.log("Không phải một tam giác");
}
isTriangle(2, 2, 0);