let trs = "";

for (let i = 1; i <= 10; i++) {
    trs += "<tr> ";
    for (let j = 2; j <= 9; j++) {
        trs += `<td>${j} x ${i} = ${i * j}</td>`;
    }
    trs += "</tr>";
}
document.getElementsByTagName("tbody")[0].innerHTML = trs;