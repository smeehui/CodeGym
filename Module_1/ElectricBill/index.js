const billCalc = (kWh) => {
    let cash;
    if (kWh < 0) {
        console.log("Số kWh không hợp lệ");
        return;
    }
    if (kWh <= 50) {
        cash = kWh * 1.678;
        return cash;
    }
    if (kWh <= 100) {
        cash = kWh * 1.734 - 50 * (1.734 - 1.678);
        return cash;
    }
    if (kWh <= 200) {
        cash = 50 * (1.678 + 1.734) + (kWh - 100) * 2.014;
        return cash;
    }
    if (kWh <= 300) {
        cash = 50 * (1.678 + 1.734) + 100 * 2.014 + (kWh - 200) * 2.536;
        return cash;
    }
    if (kWh <= 400) {
        cash =
            50 * (1.678 + 1.734) + 100 * (2.014 + 2.536) + (kWh - 300) * 2.834;
        return cash;
    }
    return (
        50 * (1.678 + 1.734) +
        100 * (2.014 + 2.536 + 2.834) +
        (kWh - 400) * 2.927
    );
};

function printRs(kWh) {
    kWh = Math.ceil(kWh);
    let bill = (billCalc(kWh) * (10 / 100) + billCalc(kWh)) * 1000;
    console.log(
        `Số tiền cần trả với số kWh: ${kWh} một tháng là ${bill.toLocaleString(
            "vi-VN",
            {
                style: "currency",
                currency: "VND",
            },
        )}`,
    );
}

// Số tiền với 500kWh
printRs(500);