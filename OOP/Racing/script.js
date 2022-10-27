const UP = "up";
const DOWN = "down";
const LEFT = "left";
const RIGHT = "right";
const DEFAULT_SPEED = 1;
const DEFAULT_POSITION_X = 300;
const DEFAULT_POSITION_Y = 580;
const GAMEBOARD_WIDTH = myCv.clientWidth;
const GAMEBOARD_HEIGHT = window.innerHeight;
class Car {
    constructor(posX, posY, speed) {
        this.posX = posX;
        this.posY = posY;
        this.orientation = UP;
        this.speed = speed;
    }
    buildImage() {
        this.carImg = this.orientation + ".png";
    }
    display(ctx) {
        var image = new Image();
        var xPosition = this.posX;
        var yPosition = this.posY;
        image.onload = function () {
            ctx.drawImage(image, xPosition, yPosition);
        };
        image.src = "./image/" + this.carImg;
        ctx.save();
        console.dir(image);
    }
    move(orient) {
        console.log(`X: ${this.posX},Y: ${this.posY}`);
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
    }
    turn(orient) {
        console.log(`X: ${this.posX},Y: ${this.posY}`);
        // this.posX -= 38 * (1 / 4);
        // this.posY += 66 * (3 / 4);

        // switch (orient) {
        //     case UP:
        //     case DOWN:
        //         this.posX += 18;
        //         break;
        //     case LEFT:
        //     case RIGHT:
        //         this.posY += 43;
        //         break;
        //     default:
        //         break;
        // }
        // this.posY -= 86 / 2;
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
        // this.car = new Car(0, 0, 1);
    }
    start() {
        this.car.buildImage();
        this.car.display(this.ctx);
    }
    render() {
        this.ctx.clearRect(0, 0, GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
        this.car.display(this.ctx);
    }
    moveCar(event) {
        let orient = UP;
        switch (event.which) {
            case 17:
                this.car.speed =
                    this.car.speed === 1 ? 10 : this.car.speed === 10 ? 20 : 1;
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
                break;
        }
        if (this.car.orientation === orient) {
            this.car.move(orient);
        } else {
            this.car.orientation = orient;
            this.car.turn(orient);
        }
        this.car.buildImage();
        this.render();
    }
}
const ctx = myCv.getContext("2d");
const gameBoard = new Board(ctx);

gameBoard.start();
