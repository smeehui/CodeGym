let trs = "";

for (let i = 2; i <= 9; i++) {
    trs += "<tr> ";
    for (let j = 1; j <= 10; j++) {
        trs += `<td>${i} x ${j} = ${i * j}</td>`;
    }
    trs += "</tr>";
}
document.getElementsByTagName("tbody")[0].innerHTML = trs;