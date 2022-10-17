const findMax = (arr) => {
    let max = arr[0];
    arr.forEach((num, i) => {
        max = num > max ? num : max;
    });
    console.log(`Số lớn nhất là ${max}`);
};
findMax([90, 5, 79]);