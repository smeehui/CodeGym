// class Temperature {
//     constructor(celsius) {
//         if (celsius >= -273) {
//             this.celsius = celsius;
//         } else {
//             console.log("Invalid celsius degree");
//         }
//     }
//     celsiusToFahrenheit() {
//         return this.celsius * (9 / 5) + 32;
//     }
//     celsiusToKelvin() {
//         return this.celsius + 273.15;
//     }
// }

let Temperature = function (celsius) {
    if (celsius >= -273) {
        this.celsius = celsius;
    } else {
        console.log("Invalid celsius degree");
    }
    this.celsiusToFahrenheit = function () {
        return this.celsius * (9 / 5) + 32;
    };
    this.celsiusToKelvin = function () {
        return this.celsius + 273.15;
    };
};
let temp1 = new Temperature(25);
console.log("F degree: " + temp1.celsiusToFahrenheit());
console.log("K degree: " + temp1.celsiusToKelvin());
