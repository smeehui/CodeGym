class Staff {
    constructor(fullName, email) {
        this.fullName = fullName;
        this.email = email;
    }

    getFullName() {
        return this.fullName;
    }

    getEmail() {
        return this.email;
    }

    setFullName(fullName) {
        this.fullName = fullName;
    }

    setEmail(email) {
        this.email = email;
    }

    toString() {
        return `Tôi là ${this.getFullName()}, địa chỉ email là ${this.getEmail()}`;
    }
}

let david = new Staff("David", "david@gmail.com");
david.setFullName("David Do");
david.setEmail("david.do@gmail.com");
// console.log(david.toString());
let khoa = new Staff("Khoa Pug", "khoa.pubg@gmail.com");
let johnny = new Staff("Johnny Dang", "johny.dang@gmail.com");
const staffs = [david, khoa, johnny];

for (let person of staffs) {
    console.log(person.toString());
}
