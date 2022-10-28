/**
 * Created by nhatnk on 4/26/17.
 */

class Hero {
    constructor(image, top, left, size) {
        this.image = image;
        this.top = top;
        this.left = left;
        this.size = size;
    }
    getHeroElement() {
        return (
            '<img width="' +
            this.size +
            '"' +
            ' height="' +
            this.size +
            '"' +
            ' src="' +
            this.image +
            '"' +
            ' style="top: ' +
            this.top +
            "px; left:" +
            this.left +
            'px;position:absolute;" />'
        );
    }
    move(ev) {
        console.log(ev);
        // switch (ev.key) {
        //     case value:
        //         break;

        //     default:
        //         break;
        // }
    }
    moveRight() {
        this.left += 20;
    }
}

var hero = new Hero("pikachu.png", 20, 30, 200);

function start() {
    if (hero.left < window.innerWidth - hero.size) {
        hero.moveRight();
    }
    document.getElementById("game").innerHTML = hero.getHeroElement();
    document.getElementsByTagName("body")[0].onkeydown = hero.move(event);
}

start();
