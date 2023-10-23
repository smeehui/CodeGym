import React, { useRef, useState } from "react";

function Login() {
    const [info, setInfo] = useState({ email: "", password: "" });
    //  const [username, setUsername] = useState("");
    //  const [password, setPassword] = useState("");

    //  const handleInputUName = (e) => {
    //      setUsername(e.target.value);
    //  };
    //  const handleInputPassword = (e) => {
    //      setPassword(e.target.value);
    //  };

    const handleInput = (e) => {
        setInfo((prev) => {
            return { ...prev, [e.target.type]: e.target.value };
        });
    };

    const handleSubmit = () => {
       console.log(info);
    };

    console.log(info);
    return (
        <form>
            <div>
                <label style={{ width: "100px", display: "inline-block" }}>
                    Email
                </label>
                <input
                    value={info.email}
                    onChange={handleInput}
                    type="email"
                />
            </div>
            <div>
                <label style={{ width: "100px", display: "inline-block" }}>
                    Password
                </label>
                <input
                    value={info.password}
                    onChange={handleInput}
                    type="password"
                />
            </div>
            <button onClick={handleSubmit} type="button">
                Submit
            </button>
        </form>
    );
}

export default Login;
