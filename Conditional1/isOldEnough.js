const checkAge = (age) => {
    console.log(
        `${
            age < 16
                ? "Không đủ điều kiệ học lớp 10"
                : "Đủ điều kiện học lớp mười"
        }`,
    );
};
checkAge(18);