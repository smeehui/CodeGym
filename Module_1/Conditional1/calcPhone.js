const calcPhoneExpanse = (min) => {
    const expense =
        min >= 200 ?
        (min - 200) * 200 + 150 * 400 + 50 * 600 + 25000 :
        min <= 50 ?
        min * 600 + 25000 :
        (min - 50) * 400 + 50 * 600 + 25000;
    console.log(
        `Chi phí điện thoại cho ${min} phú gọi là ${expense.toLocaleString(
            "vi-VN",
            {
                style: "currency",
                currency: "VND",
            },
        )}`,
    );
};
calcPhoneExpanse(50);