let Circle = function (radius, color) {
    this.radius = radius;
    this.color = color;
    this.Circle = function () {
        return this;
    };
    this.getRadius = function () {
        return this.radius;
    };
    this.getArea = function () {
        return (Math.PI * radius * radius).toFixed(4);
    };
};
let circle1 = new Circle(12, "red");
console.log(circle1.getArea());
console.log(circle1.getRadius());
