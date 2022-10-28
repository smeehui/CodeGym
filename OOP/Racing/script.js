const UP = "up";
const DOWN = "down";
const LEFT = "left";
const RIGHT = "right";
const DEFAULT_SPEED = 1;
const DEFAULT_POSITION_X = 300;
const DEFAULT_POSITION_Y = 580;
const GAMEBOARD_WIDTH = myCv.clientWidth;
const GAMEBOARD_HEIGHT = myCv.clientHeight;
const SQUARE_OBST = "square";
const RECTANGL_OBST = "rect";
class Car {
    constructor(posX, posY, speed) {
        this.posX = posX;
        this.posY = posY;
        this.orientation = UP;
        this.speed = speed;
    }
    buildImage() {
        this.Img = this.orientation + ".png";
    }
    display(ctx) {
        var image = new Image();
        var xPosition = this.posX;
        var yPosition = this.posY;
        image.onload = function () {
            ctx.drawImage(image, xPosition, yPosition);
        };
        image.src = "./images/" + this.Img;
    }
    move(orient) {
        switch (orient) {
            case UP:
                this.posY -= this.speed;
                break;
            case DOWN:
                this.posY += this.speed;
                break;
            case LEFT:
                this.posX -= this.speed;
                break;
            case RIGHT:
                this.posX += this.speed;
                break;
            default:
                break;
        }
        if (this.posX < 0) {
            this.posX = GAMEBOARD_WIDTH;
        }
    }
    turn(orient) {
        switch (orient) {
            case UP:
            case DOWN:
                this.posX += (86 - 43) / 2;
                this.posY -= (86 - 43) / 2;
                break;
            case LEFT:
            case RIGHT:
                this.posX -= (86 - 43) / 2;
                this.posY += (86 - 43) / 2;
                break;
            default:
                break;
        }
    }
}
class Obstacle extends Car {
    constructor(posX) {
        super();
        this.posY = 0;
        this.shape = SQUARE_OBST;
        this.posX = posX;
    }
    buildObstacle() {
        this.Img = this.shape + ".png";
    }
    fall() {
        var intID = setInterval(() => {
            this.posY += 1;
            // gameBoard.render();
            if (this.posY > GAMEBOARD_HEIGHT) {
                clearInterval(intID);
            }
        }, 10);
    }
}
class Board {
    constructor(ctx) {
        this.ctx = ctx;
        this.car = new Car(
            DEFAULT_POSITION_X,
            DEFAULT_POSITION_Y,
            DEFAULT_SPEED,
        );
        this.amoutOfObstacles = 10;
    }
    start() {
        this.car.buildImage();
        this.car.display(this.ctx);
        this.createObst();
        this.fallObstacle();
    }
    render() {
        this.showObstacles();
        this.ctx.clearRect(0, 0, GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
        this.car.display(this.ctx);
    }
    randomPosition(min, max, buffer, maxcount) {
        let randomBetween = (min, max) =>
            Math.floor(Math.random() * (max - min + 1) + min);

        function addLeaves(f, min, max, arr = []) {
            if (arr.length < maxcount) {
                arr.push(f);
                if (min + buffer < f - buffer)
                    addLeaves(
                        randomBetween(min + buffer, f - buffer),
                        min,
                        f,
                        arr,
                    );
                if (f + buffer < max - buffer)
                    addLeaves(
                        randomBetween(f + buffer, max - buffer),
                        f,
                        max,
                        arr,
                    );
            }
            return arr;
        }
        return addLeaves(randomBetween(min, max), min - buffer, max + buffer);
    }
    moveCar(event) {
        let orient = UP;
        switch (event.which) {
            case 17:
                this.car.speed =
                    this.car.speed === 1 ? 10 : this.car.speed === 10 ? 20 : 1;
                return;
            case 38:
                orient = UP;
                break;
            case 40:
                orient = DOWN;
                break;
            case 37:
                orient = LEFT;
                break;
            case 39:
                orient = RIGHT;
                break;
            default:
                return;
        }
        if (this.car.orientation === orient) {
            this.car.move(orient);
            this.car.buildImage();
            this.render();
        } else {
            this.car.orientation = orient;
            this.car.turn(orient);
            this.car.buildImage();
            this.render();
        }
    }
    createObst() {
        this.obstacles = [];
        let positions = this.randomPosition(0, GAMEBOARD_WIDTH, 40, 10);
        console.log(positions);
        for (let i = 0; i < this.amoutOfObstacles; i++) {
            this.obstacles[i] = new Obstacle(positions[i]);
        }
        for (let i = 0; i < this.amoutOfObstacles; i++) {
            this.obstacles[i].buildObstacle();
        }
        console.log(this.obstacles);
    }
    showObstacles() {
        for (let i = 0; i < this.amoutOfObstacles; i++) {
            this.obstacles[i].display(this.ctx);
        }
    }
    fallObstacle() {
        for (let i = 0; i < this.amoutOfObstacles; i++) {
            this.obstacles[i].fall();
        }
    }
    checkWin(posX, posY, intID) {
        if (posY > this.car.posY) {
            console.log(posX, posY, this.car.posX, this.car.posY);
            alert("YOU DIED");
            clearInterval(intID);
        }
    }
}
const ctx = myCv.getContext("2d");
const gameBoard = new Board(ctx);

gameBoard.start();
