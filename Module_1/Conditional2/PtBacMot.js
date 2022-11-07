function giaiPt(a, b) {
    if (a == 0 && b == 0) {
        console.log("PT có vô số nghiệm");
        return;
    }
    if (a == 0 && b != 0) {
        console.log("PT vô nghiệm");
        return;
    }
    console.log(`PT có nghiệm là ${-b / a}`);
}
giaiPt(0, 2);