function checkAge(age) {
    if (age < 120 && age > 0 && Number.isInteger(age)) {
        console.log(`${age} Là tuổi thật của con người`);
        return;
    }
    console.log(`${age} không phải là tuổi của con người`);
}
checkAge(15);