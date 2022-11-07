class Apple {
    constructor() {
        this.weight = 10;
    }
    decrease() {
        this.setWeight(this.weight - 1);
        this.isEmpty();
    }
    isEmpty() {
        if (this.weight === 0) {
            return true;
        } else {
            this.getWeight();
            return false;
        }
    }
    getWeight() {
        return this.weight;
    }
    setWeight(weight) {
        this.weight = weight;
    }
}

class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }
    isMale() {
        if (this.gender === true) {
            return true;
        } else {
            return false;
        }
    }
    setGender(gender) {
        this.gender = gender;
    }
    checkApple(apple) {
        apple.isEmpty();
    }
    say(string) {
        console.log(string);
    }
    getName() {
        return this.name;
    }
    setName(name) {
        this.name = name;
    }
    getWeight() {
        return this.weight;
    }
    setWeight(weight) {
        this.weight = weight;
    }
    eat(apple) {
        this.setWeight(this.weight + 1);
        apple.decrease();
    }
}
const adam = new Human("adam", true, 80);
const eva = new Human("eva", false, 50);
const apple = new Apple();
while (apple.weight > 0) {
    adam.eat(apple);
    document.write(
        `Adam ate apple,<br> adam weight increase 1: ${adam.weight} unit(s), <br> apple weight is ${apple.weight} unit(s) remaining <br> <br><br>`,
    );
    eva.eat(apple);
    document.write(
        `eva ate apple,<br> eva weight increase 1: ${eva.weight} unit(s), <br> apple weight is ${apple.weight} unit(s) remaining <br> <br><br>`,
    );
}
