const arr1 = [3, 5, 1, 8, -3, 7, 8];

const arr2 = [7, 12, 6, 9, 20, 56, 89];

const arr3 = [];

const arr4 = [0, 0, 0, 0, 0, 0];

function findMin(arr) {
    if (typeof arr[0] === "undefined") {
        console.log(`Invalid array`);
        return;
    }
    let min = arr[0];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    console.log(`Min number is: ${min}`);
}
findMin(arr1);
findMin(arr2);
findMin(arr3);
findMin(arr4);
