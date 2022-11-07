class Parent {
    static hey() {
        console.log(`hey`);
    }
}

class Child extends Parent {
    constructor() {
        super();
    }
}
Child.hey();
