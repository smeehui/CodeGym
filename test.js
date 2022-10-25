let num1 = [1, 2, 3, 4, 5];
let num2 = num1;
num2 = num1.slice(0, num1.length);
num2.splice(1, 1);
console.log(num2);
console.log(num1);
