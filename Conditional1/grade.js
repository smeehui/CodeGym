// Hệ số một: single
// Hệ số hai: double
// Hệ số ba: triple

const grade = (single, double, triple) => {
    const average = ((single + double * 2 + triple * 3) / 6).toFixed(1);
    console.log(
        `Học lực ${
            average < 5
                ? "yếu"
                : average < 6.5
                ? "trung bình"
                : average < 7.5
                ? "khá"
                : average < 8.5
                ? "giỏi"
                : "xuất xắc"
        }`,
    );
};
grade(6, 9, 9);