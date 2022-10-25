const products = [
    "iPhone 6 Plus",
    "iPhone XS Max",
    "Iphone 14 Pro Max",
    "Ipad Mini 6",
    "Macbook Pro 2020",
];
function render(prods) {
    const htmls = prods.map(
        (prod, index) => `
                        <tr data-id="${index} class="prod-row"">
                           <td class="prod-name">${prod}</td>
                           <td><button class="edit btn">Edit</button></td>
                           <td><button class="delete btn">Delete</button></td>
                        </tr> 
                        `,
    );
    listProds.innerHTML = htmls.join("");
}
render(products);

listProds.onclick = function (e) {};
