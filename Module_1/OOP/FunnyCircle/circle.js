let Circle = function (x, y, radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
};
function getRandomHex() {
    return Math.floor(Math.random() * 256);
}
function getRandomColor() {
    let red = getRandomHex();
    let green = getRandomHex();
    let blue = getRandomHex();
    let opacity = Math.floor(Math.random() * 101) / 100;
    return `rgb(${red},${green},${blue}, ${opacity})`;
}

function createCircle() {
    var ctx = document.getElementById("myCanvas").getContext("2d");
    var circle = new Circle(
        Math.random() * window.innerWidth,
        Math.random() * window.innerHeight,
        Math.random() * 80,
    );
    let color = getRandomColor();
    ctx.beginPath();
    ctx.arc(circle.x, circle.y, circle.radius, 0, 2 * Math.PI);
    ctx.fillStyle = color;
    ctx.fill();
}
let intID = setInterval(() => {
    createCircle();
}, 50);

window.onkeydown = () => {
    clearInterval(intID);
};
