function laiKep(loan, rate, circle, year) {
    let total = (loan * (1 + rate / circle) ** circle * year).toLocaleString(
        "vi-VN", {
            style: "currency",
            currency: "VND",
        },
    );
    console.log(total);
}
laiKep(4000000000, 0.06, 4, 1);