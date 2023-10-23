import React from "react";
import { Link, NavLink } from "react-router-dom";

function Navbar() {
    const links = [
        { to: "/useState/getGift", title: "USE STATE - Gift" },
        { to: "/useState/login", title: "USE STATE - Login" },
        { to: "/useState/prod-management", title: "USE STATE - Product Management" },
    ];
    return (
        <div style={{ marginBottom: "20px" }}>
            {links.map((link,index)=><NavLink style={{margin:"0 10px"}} key={index} to={link.to}>{link.title}</NavLink>)}
        </div>
    );
}

export default Navbar;
