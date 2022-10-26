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
        this.inboxMsgs = [{ add: "", message: "" }];
        this.sentMsgs = [{ add: "", message: "" }];
        this.isOn = isOn;
    }
    checkStatus() {
        if (this.isOn) {
            console.log(`Phone is powered on`);
        } else {
            console.log(`Phone is powered off`);
        }
    }
    turnOn() {
        this.isOn = true;
        console.log("Turned on phone");
    }
    turnOff() {
        this.isOn == false;
        console.log("Turned off phone");
    }
}
