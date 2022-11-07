const products = [
    "iPhone 6 Plus",
    "iPhone XS Max",
    "Iphone 14 Pro Max",
    "Ipad Mini 6",
    "Macbook Pro 2020",
];
function render(prods) {
    numberProd.innerText = `${products.length} products`;
    const htmls = prods.map(
        (prod, index) => `
                        <tr data-id="${index}" class="prod-row">
                           <td class="prod-name">${prod}</td>
                           <td ><button class="edit btn">Edit</button></td>
                           <td ><button class="delete  btn">Delete</button></td>
                        </tr> 
                        `,
    );
    listProds.innerHTML = htmls.join("");
}
render(products);

listProds.onclick = function (e) {
    let id = Number(e.target.closest(".prod-row").dataset.id);
    if (e.target.classList.contains("edit")) {
        editProduct(id);
        return;
    }
    if (e.target.classList.contains("delete")) {
        deleteProduct(id);
        return;
    }
};
addBtn.onclick = () => {
    let product = prodName.value;
    if (product.trim()) {
        products.push(product);
        render(products);
    }
    prodName.value = "";
    prodName.focus();
};
function editProduct(id) {
    const newProd = prompt("Enter new product name");
    products.splice(id, 1, newProd);
    render(products);
}
function deleteProduct(id) {
    let check = confirm("Do you really want to delete this product");
    if (check) {
        products.splice(id, 1);
        render(products);
    }
}
