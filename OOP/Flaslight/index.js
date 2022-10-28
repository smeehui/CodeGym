class Battery {
    constructor() {
        this.setEnergy = function (energy) {
            this.energy = energy;
        };

        this.getEnergy = function () {
            return this.energy;
        };

        this.decreaseEnergy = function () {
            if (this.energy > 0) {
                this.energy--;
            }
        };
    }
}

class FlashLamp {
    constructor() {
        this.setBattery = function (battery) {
            this.battery = battery;
        };

        this.getBatteryInfo = function () {
            return this.battery.getEnergy();
        };

        this.light = function () {
            if (this.status) {
                alert("Lighting");
            } else {
                alert("Not lighting");
            }
        };

        this.turnOn = function () {
            this.status = true;
        };

        this.turnOff = function () {
            this.status = false;
        };
    }
}
let battery = new Battery();
battery.setEnergy(10);

let flashLamp = new FlashLamp();
flashLamp.setBattery(battery);
