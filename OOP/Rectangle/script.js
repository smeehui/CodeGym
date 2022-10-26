class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }
    getWidth() {
        return this.width;
    }
    getHeight() {
        return this.height;
    }
    setWidth(width) {
        this.width = width;
    }
    setHeight(height) {
        this.height = height;
    }
    getArea() {
        return this.width * this.height;
    }
    getPerimeter() {
        return (this.width + this.height) * 2;
    }
    draw(crx, x, y, color) {
        crx.fillStyle = color;
        crx.fillRect(x, y, this.width, this.height);
    }
}
let crx = myCv.getContext("2d");
// new Rectangle
const rect1 = new Rectangle(500, 200);
// show Area and Perimeter
const displayAreaAndPerimeter = () => {
    area.innerText = rect1.getArea();
    perimeter.innerText = rect1.getPerimeter();
};
displayAreaAndPerimeter();
// Draw Rectangle
const drawRect = () => {
    rect1.draw(crx, 20, 20, "red");
};
drawRect();
// setWidth Height
setNew.onclick = () => {
    crx.clearRect(0, 0, myCv.width, myCv.height);
    let newWidth = Number(inpWidth.value);
    let newHeight = Number(inpHeight.value);
    setWidthHeight(newWidth, newHeight);
    console.log(newWidth, newHeight);
    drawRect();
    displayAreaAndPerimeter();
};
const setWidthHeight = (newWidth, newHeight) => {
    rect1.setWidth(newWidth);
    rect1.setHeight(newHeight);
};
