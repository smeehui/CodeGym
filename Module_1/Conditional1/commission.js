// Hoa hồng: com
// Doanh thu: revenue

const calCommision = (com, revenue) => {
    let money = ((com / 100) * revenue).toLocaleString("vi-VN", {
        style: "currency",
        currency: "VND",
    });
    console.log(`Doanh thu ở ${com} phần trăm là ${money}`);
};

calCommision(10, 1000000000);