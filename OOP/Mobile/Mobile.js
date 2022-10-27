// Viết một lớp các đối tượng điện thoại lấy tên là Mobile,
// mỗi một chiếc mobile phone khi được tạo ra sẽ mang những đặc điểm sau:

// Có một thông số về trạng thái pin tính bằng đơn vị số nguyên (tối đa 100 đv)
// Có một vùng nhớ dùng để lưu tin nhắn đang soạn thảo.
// Có một vùng nhớ dùng để lưu tin nhắn trong hộp thư đến.
// Có một vùng nhớ dùng để lưu tin nhắn đã gửi.
// Có chức năng kiểm tra trạng thái điện thoại bật hay tắt.
// Có chức năng bật và tắt điện thoại.
// Có chức năng xạc pin điện thoại.
// Có chức năng soạn tin nhắn.
// Có chức năng nhận tin nhắn từ một chiếc mobile khác.
// Có chức năng gửi tin nhắn tới một chiếc mobile khác.
// Có chức năng xem tin trong hộp thư đến.
// Có chức năng xem tin đã gửi.
// Sau mỗi lần sử dụng một chức năng, năng lượng pin sẽ giảm đi một đơn vị.
// Các chức năng không thể hoạt động nếu điện thoại chưa bật.

class Mobile {
    constructor(name) {
        this.battery = Math.floor(Math.random() * 101);
        this.name = name;
        this.typingMsg = "";
        this.isOn = false;
        this.inboxMsgs = [];
        this.sentMsgs = [];
    }
    getSentMsgs() {
        return this.sentMsgs;
    }
    getInboxMsgs() {
        return this.inboxMsgs;
    }
    checkStatus() {
        if (!this.isOn) {
            console.log(`${this.name} is powered off`);
            return;
        }
        if (this.battery < 0) {
            this.turnOff();
            console.log(`${this.name} is low battery`);
        }
    }
    turnOn() {
        if (this.battery > 0) {
            if (this.isOn) {
                console.log(`${this.name} is already powered on`);
            } else {
                this.isOn = true;
                console.log(`Turned on ${this.name}`);
            }
        } else {
            console.log(`Low battery`);
        }
    }
    turnOff() {
        if (this.isOn) {
            this.isOn = false;
            console.log(`Turned off ${this.name}`);
        } else {
            console.log(`${this.name} is already powered off`);
        }
    }
    charge() {
        if (!this.isOn) {
            this.turnOn();
            console.log("Phone is charging");
            this.battery += 5;
            console.log(`Phone battery is ${this.battery}`);
            if (this.battery > 100) {
                console.log("Phone is fully charged");
            }
        } else {
            console.log("Phone is charging");
            this.battery += 5;
            console.log(`Phone battery is ${this.battery}`);
        }
    }
    typeMsg(message) {
        if (this.isOn) {
            this.checkStatus();
            this.typingMsg += message;
            this.battery -= 10;
            this.checkStatus();
        } else {
            console.log(`${this.name} is powered off`);
        }
    }
    sendMsg(address) {
        if (this.isOn) {
            this.checkStatus();
            console.log(`${this.name}: Message is sent to ${address.name}`);
            address.receiveMsg(this.typingMsg, this.name);
            this.sentMsgs.push({
                sentTo: address.name,
                message: this.typingMsg,
            });
            this.typingMsg = "";
            this.battery -= 10;
            this.checkStatus();
        } else {
            console.log(`${this.name} is powered off`);
        }
    }
    receiveMsg(message, sentPhone) {
        if (this.isOn) {
            this.checkStatus();
            console.log(
                `${this.name}: A new message is received from ${sentPhone}:`,
            );
            console.log(message);
            this.inboxMsgs.push({ receivedFrom: sentPhone, message: message });
            this.battery -= 10;
            this.checkStatus();
        } else {
            console.log(`${this.name} is powered off`);
        }
    }
}
let iPhone = new Mobile("iPhone");
let nokia = new Mobile("nokia");
iPhone.turnOn();
nokia.turnOn();
iPhone.typeMsg("Ăn cơm chưa");
iPhone.sendMsg(nokia);
iPhone.typeMsg("Anh nhớ em");
iPhone.sendMsg(nokia);
iPhone.checkStatus();
let timerID = setTimeout(() => {
    nokia.typeMsg("Em ăn rồi nè");
    nokia.sendMsg(iPhone);
    nokia.typeMsg("Em cũng nhớ anh");
    nokia.sendMsg(iPhone);
    return clearTimeout(timerID);
}, 5000);
