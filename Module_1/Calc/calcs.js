const syms = document.querySelectorAll(".sym");
const calcs = document.querySelectorAll(".calc");
const nums = document.querySelectorAll(".num");
const input = document.getElementById("input");
const ndEs = document.getElementsByTagName("td");
const eql = document.getElementById("#eql");

function convertToCalc(obj) {
    return eval(`${obj}`);
}
const app = {
    inputVls: "",
    func: "",
    ans: "",
    numValues: "",
    cornFlag: false,
    calcFlag: false,
    eqlFlag: false,
    onClick: function(e) {
        if (e.target.dataset.rs) {
            app.inputVls = "";
            app.func = "";
            app.numValues = "";
            app.eqlFlag = false;
            app.renderInput("0");
        }
        if (app.eqlFlag) {
            app.renderInput(
                `Previous ANS = ${app.ans}, please press AC or reload`,
            );
            return;
        }
        if (e.target.classList.contains("eql")) {
            if (app.func) {
                if (app.cornFlag) {
                    const degCorn =
                        (convertToCalc(app.numValues) * Math.PI) / 180;
                    const result = convertToCalc(app.func + degCorn + ")");
                    app.cornFlag = false;
                    app.ans = result.toFixed(4);
                    app.renderInput(app.ans);
                } else {
                    const result = convertToCalc(
                        app.func + convertToCalc(app.numValues) + ")",
                    );
                    app.ans = result;
                    app.renderInput(result);
                }
            } else {
                const result = convertToCalc(app.inputVls);
                app.ans = result;
                app.renderInput(result);
            }
            app.eqlFlag = true;
        } else if (e.target.dataset.value) {
            if (app.cornFlag || app.calcFlag) {
                if (e.target.dataset.num) {
                    app.numValues += e.target.dataset.num;
                }
                app.renderInput(app.inputVls);
            }
            if (e.target.dataset.corn) {
                app.cornFlag = true;
                app.inputVls += e.target.dataset.value;
                app.func = e.target.dataset.corn;
                app.renderInput(app.inputVls);
            } else if (e.target.dataset.calc) {
                app.calcFlag = true;
                app.func = e.target.dataset.calc;
                app.inputVls += e.target.dataset.value;
                app.renderInput(app.inputVls);
            } else {
                app.inputVls += e.target.dataset.value;
                app.renderInput(app.inputVls);
            }
        }
    },
    handleEvents: function() {
        // Click elements
        const nds = Array.from(ndEs);
        nds.forEach((nd) => {
            nd.onclick = app.onClick;
        });
    },
    renderInput: function(value) {
        if (value === "0") {
            input.setAttribute("placeholder", 0);
            input.value = 0;
        } else {
            input.value = value;
        }
    },
    //  strt app
    start: function() {
        // handle event
        app.handleEvents();
    },
};
app.start();