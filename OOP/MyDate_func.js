let MyDate = function (date, month, year) {
    this.date = date;
    this.month = month;
    this.year = year;
    this.getDate = function () {
        return this.date;
    };
    this.getMonth = function () {
        return this.month;
    };
    this.getYear = function () {
        return this.year;
    };
    this.getFullDate = function () {
        return `${this.date}-${this.month}-${this.year}`;
    };
    this.setDate = function (date) {
        if (date > 0 && date < 31) {
            this.date = date;
        }
    };
    this.setMonth = function (month) {
        if (month > 0 && month < 12) {
            this.month = month;
        }
    };
    this.setYear = function (year) {
        if (year > 0) {
            this.year = year;
        }
    };
};
let birthDate = new MyDate(17, 06, 1999);
birthDate.setDate(26);
birthDate.setMonth(9);
console.log(birthDate.getFullDate());
