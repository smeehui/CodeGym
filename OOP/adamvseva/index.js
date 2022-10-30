class Apple {
    constructor() {
        this.weight = 10;
    }
    decrease() {
        this.weight--;
        this.isEmpty();
    }
    isEmpty() {
        if (this.weight === 0) {
            console.log("Done");
            return true;
        } else {
            console.log(this.weight + " weight remained");
            return false;
        }
    }
    getWeight() {
        return this.weight;
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
            console.log("Male");
            return true;
        } else {
            console.log("Female");
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
        console.log(`${this.name}: eated`);
        apple.decrease();
    }
}
const adam = new Human("adam", true, 80);
const eva = new Human("eva", false, 50);
const apple = new Apple();
while (apple.weight > 0) {
    adam.eat(apple);
    eva.eat(apple);
}
