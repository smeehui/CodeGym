class Customer {
    constructor(id, name, email, phone, address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}

let customers = [];

$("#fSubmit").click(createNewCustomer);

function createNewCustomer(e) {
    e.preventDefault();
    let id = generateId();
    let fullName = $("#inputName").val();
    let email = $("#inputEmail").val();
    let phone = $("#inputPhone").val();
    let address = $("#inputAddress").val();
    let customer = new Customer(id, fullName, email, phone, address);
    customers.unshift(customer);
    appendToTable(customer);
}
function generateId() {
    return "id" + Math.random().toString(16).slice(2);
}

function appendToTable(customer) {
    let tr = createTableRow(customer);
    $("#tbody").prepend(tr);
    addQueue();
}
function createTableRow(customer) {
    return `
   <tr class="c${customer.id}">
   <td class="queue"></td>
   <td>${customer.name}</td>
   <td>${customer.email}</td>
   <td>${customer.phone}</td>
   <td>${customer.address}</td>
   <td><button 
         class="btn btn-sm btn-outline-warning"
         type="button"
         class="btn btn-primary"
         data-bs-toggle="modal"
         data-bs-target="#editCustomerModal"
         data-customerID=${customer.id}
         onclick="editCustomer(this.dataset.customerid)"
         >Edit</button></td>
   <td><button 
         class="btn btn-sm btn-outline-danger"
         data-bs-toggle="modal"
         data-bs-target="#deleteCustomerModal"
         data-customerID=${customer.id}
         onclick="appendInfoToDeleteModal(this.dataset.customerid)"
         >Delete</button></td>
   </tr>

   `;
}
function addQueue() {
    $(".queue").each(function (e) {
        console.log(e);
        this.innerText = e + 1;
    });
}

function editCustomer(id) {
    let customer = customers.filter((c) => c.id == id)[0];
    $("#editName").val(customer.name);
    $("#editEmail").val(customer.email);
    $("#editPhone").val(customer.phone);
    $("#editAddress").val(customer.address);
    $("#saveCustomerBtn").attr("data-customerid", id);
    //  tr.replaceWith(createTableRow(customer));
}

$("#saveCustomerBtn").click(saveCustomer);
function saveCustomer(e) {
    let id = e.target.dataset.customerid;
    let fullName = $("#editName").val();
    let email = $("#editEmail").val();
    let phone = $("#editPhone").val();
    let address = $("#editAddress").val();
    let customer = customers.filter((c) => c.id == id)[0];

    if (fullName.length > 0) customer.name = fullName;
    if (email.length > 0) customer.email = email;
    if (phone.length > 0) customer.phone = phone;
    if (address.length > 0) customer.address = address;

    customers.forEach((c, i) => {
        if (c.id == customer.id) customers[i] = customer;
    });
    let tr = $(`.c${id}`);
    tr.replaceWith(createTableRow(customer));
    addQueue();
}
function appendInfoToDeleteModal(id) {
    let customer = customers.filter((c) => c.id == id)[0];
    $("#delCusName").text(customer.name);
    $("#delCusEmail").text(customer.email);
    $("#delCusPhone").text(customer.phone);
    $("#delCusAddress").text(customer.address);
    $("#deleteCustomerBtn").attr("data-customerid", id);
}

$("#deleteCustomerBtn").click(deleteCustomer);

function deleteCustomer(e) {
    let id = e.target.dataset.customerid;
    customers = customers.filter((c) => c.id != id);
    $(`.c${id}`).remove();
    addQueue();
}
