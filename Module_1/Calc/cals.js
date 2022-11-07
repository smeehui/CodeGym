const syms = document.querySelectorAll(".sym");
const calcs = document.querySelectorAll(".calc");
const nums = document.querySelectorAll(".num");
const input = document.getElementsByTagName("input");
const ndEs = document.getElementsByTagName("td");
const eql = document.getElementById("#eql");

const app = {
    storedValues: [],
    values: [],
    splitedValues: [],
    ans: 0,
    eqlFlag: false,
    mtplFlag: false,
    calc: function(arr) {
        const convert = arr.map((num) => Number(num));
        const rNums = convert.filter((num) => !!num == true);
        const check = arr.some((num) => num === "*" || num === "/");
        if (check) {
            switch (arr[1]) {
                case "*":
                    const mult = rNums.reduce((rsult, curr, i) => {
                        return rsult * curr;
                    });
                    app.ans = mult;
                    app.renderInput(mult);
                    break;
                case "/":
                    const divs = rNums.reduce((div, curr) => div / curr);
                    app.ans = divs;
                    app.renderInput(divs);
            }
        } else {
            const total = rNums.reduce((total, curr) => total + curr);
            app.ans = total;
            app.renderInput(total);
        }
    },
    onClick: function(e) {
        if (app.eqlFlag) {
            app.renderRevw("0");
            app.renderInput("0");
            app.storedValues = [];
            app.values = [];
        }

        if (e.target.dataset.value) {
            app.values.push(e.target.dataset.value);
            app.splitedValues = app.splitValue(app.values.join(""));
            app.renderRevw(app.values.join(""));
        }
        if (e.target.dataset.num) {
            app.eqlFlag = false;
            var inp = app.saveValue(e.target.dataset.value);
            app.renderInput(inp);
        } else if (e.target.dataset.calc) {
            app.eqlFlag = false;
            var inp = app.saveValue(e.target.dataset.value);
            app.renderInput(inp);
        } else if (e.target.dataset.sym) {
            app.eqlFlag = false;
            app.storedValues = [];
            var inp = app.saveValue(e.target.dataset.value);
            app.renderInput(inp);
        } else if (e.target.dataset.rs) {
            app.eqlFlag = false;
            app.resetInp();
        } else if (e.target.classList.contains("mtpl")) {
            app.eqlFlag = false;
            var inp = app.saveValue(e.target.dataset.value);
            app.renderInput(inp);
        } else if (e.target.classList.contains("eql")) {
            if (!app.eqlFlag) {
                const splitedVals = app.splitValue(app.values.join(""));
                app.calc(splitedVals);
                app.eqlFlag = true;
            }
        }
        // Press Ans
        else if (e.target.classList.contains("ans")) {
            app.values = [app.ans];
            app.renderInput(app.ans);
            app.renderRevw("Previous Ans");
        }
        if (app.splitedValues.length > 3) {
            app.renderInput("Only one calculation, press AC");
            return;
        }
    },
    onInput: function(e) {
        app.renderInput("Input is not supported");
    },
    splitValue: function(value) {
        const regex =
            /([*/])|([0-9]+[\.][0-9]+)|([0-9]+)|([^0-9][0-9]+[\.][0-9]+)|([^0-9][0-9]+)/g;
        return value.match(regex);
    },
    saveValue: function(value) {
        app.storedValues.push(value);
        var newStValue = app.storedValues.join("");
        return newStValue;
    },
    deleteOne: function() {
        app.renderInput(app.values.splice(-1, 1).join(""));
    },
    resetInp: function() {
        app.storedValues = [];
        app.values = [];
        app.splitedValues = [];
        app.renderInput("0");
        app.renderRevw("0");
    },
    handleEvents: function() {
        // Click elements
        const nds = Array.from(ndEs);
        nds.forEach((nd) => {
            nd.onclick = app.onClick;
        });

        // on change Input
        input[1].oninput = app.onInput;
    },
    renderRevw: function(value) {
        input[0].setAttribute("placeholder", value);
    },
    renderInput: function(value) {
        input[1].value = value;
    },
    //  strt app
    start: function() {
        // handle event
        app.handleEvents();
    },
};
app.start();