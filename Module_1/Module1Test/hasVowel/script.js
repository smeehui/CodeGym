checkBtn.onclick = function () {
    let string = stringInput.value;
    message.innerText = hasVowel(string);
};

function hasVowel(string) {
    let count = 0;

    for (let i = 0; i < string.length; i++) {
        if (
            string[i].toLowerCase() === "a" ||
            string[i].toLowerCase() === "e" ||
            string[i].toLowerCase() === "u" ||
            string[i].toLowerCase() === "o" ||
            string[i].toLowerCase() === "i"
        ) {
            count++;
        }
    }

    return count === 0 ? false : count;
}
