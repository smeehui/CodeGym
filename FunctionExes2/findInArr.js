const string = "Lorem ipsum dolor sit amet consectetur adipisicing elit.";
const strArr = string.split("");
function findString(arr, char) {
    let count = 0;
    let isFound = false;
    for (let i = 0; i < arr.length; i++) {
        const element = arr[i];
        if (element === char) {
            isFound = true;
            count++;
        }
    }
    return isFound ? count : -1;
}
let character = "x";
let times = findString(strArr, character);
console.log(
    times > 0
        ? `Character ${character} is found ${times} time(s)`
        : `Character ${character} is not found`,
);
