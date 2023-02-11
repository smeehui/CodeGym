function init() {
    class Customer {
        constructor(id, name, email, phone, address) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }
    }
    return (app = {
        customers: [],

        currentCustomer: null,

        generateId: function () {
            return "id" + Math.random().toString(16).slice(2);
        },

        createBtnListener: function () {
            $("#fSubmit").click(this.createNewCustomer);
        },

        createNewCustomer: function (e) {
            e.preventDefault();
            let id = app.generateId();
            let fullName = $("#inputName").val();
            let email = $("#inputEmail").val();
            let phone = $("#inputPhone").val();
            let address = $("#inputAddress").val();
            let customer = new Customer(id, fullName, email, phone, address);
            app.customers.unshift(customer);
            app.appendToTable(customer);
            app.addQueue();
            app.resetCreateForm();
        },

        resetCreateForm: function () {
            $("#inputName").val("");
            $("#inputEmail").val("");
            $("#inputPhone").val("");
            $("#inputAddress").val("");
        },

        addCustomerHandler: function () {
            this.createBtnListener();
        },

        appendToTable: function (customer) {
            let tr = this.createTableRow(customer);
            $("#tbody").prepend(tr);
        },

        addQueue: function () {
            $(".queue").each(function (e) {
                this.innerText = e + 1;
            });
        },

        createTableRow: function (customer) {
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
                            onclick="app.setCurrentCustomer(this.dataset.customerid)"
                            >Edit</button></td>
                    <td><button 
                            class="btn btn-sm btn-outline-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteCustomerModal"
                            data-customerID=${customer.id}
                            onclick="app.setCurrentCustomer(this.dataset.customerid)"
                            >Delete</button></td>
                    </tr>
    
                    `;
        },

        createSaveBtnLister: function () {
            let _this = this;
            $("#saveCustomerBtn").click(_this.saveCustomer);
            this.appendCurrentCustomerInfoToEditForm();
        },

        appendCurrentCustomerInfoToEditForm: function () {
            let customer = this.currentCustomer;
            $("#editName").val(customer.name);
            $("#editEmail").val(customer.email);
            $("#editPhone").val(customer.phone);
            $("#editAddress").val(customer.address);
        },

        setCurrentCustomer: function (id) {
            this.currentCustomer = this.customers.filter((c) => c.id == id)[0];
            this.editCustomerHandler();
            this.deleteCustomerHandler();
        },

        saveCustomer: function () {
            let customer = app.currentCustomer;
            let id = customer.id;
            let fullName = $("#editName").val();
            let email = $("#editEmail").val();
            let phone = $("#editPhone").val();
            let address = $("#editAddress").val();

            if (fullName.length > 0) customer.name = fullName;
            if (email.length > 0) customer.email = email;
            if (phone.length > 0) customer.phone = phone;
            if (address.length > 0) customer.address = address;

            app.customers.forEach((c, i) => {
                if (c.id == customer.id) app.customers[i] = customer;
            });
            let tr = $(`.c${id}`);
            tr.replaceWith(app.createTableRow(customer));
            app.addQueue();
        },

        createDeleteBtnListener: function () {
            let _this = this;
            $("#deleteCustomerBtn").click(_this.deleteCustomer);
        },

        appendInfoToDeleteModal: function () {
            let customer = this.currentCustomer;
            $("#delCusName").text(customer.name);
            $("#delCusEmail").text(customer.email);
            $("#delCusPhone").text(customer.phone);
            $("#delCusAddress").text(customer.address);
        },

        deleteCustomer: function () {
            let id = app.currentCustomer.id;
            app.customers = app.customers.filter((c) => c.id != id);
            $(`.c${id}`).remove();
            app.addQueue();
        },

        deleteCustomerHandler: function () {
            this.createDeleteBtnListener();
            this.appendInfoToDeleteModal();
        },

        editCustomerHandler: function () {
            this.createSaveBtnLister();
        },

        start: function () {
            this.addCustomerHandler();
        },
    });
}
let App = init();
App.start();
