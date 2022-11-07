class MyDate {
    constructor(date, month, year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
    getDate() {
        return this.date;
    }
    getMonth() {
        return this.month;
    }
    getYear() {
        return this.year;
    }
    getFullDate() {
        return `${this.date}-${this.month}-${this.year}`;
    }
    setDate(date) {
        if (date > 0 && date < 31) {
            this.date = date;
        }
    }
    setMonth(month) {
        if (month > 0 && month < 12) {
            this.month = month;
        }
    }
    setYear(year) {
        if (year > 0) {
            this.year = year;
        }
    }
}
let birthDate = new MyDate(26, 9, 1999);
console.log(birthDate.getFullDate());
