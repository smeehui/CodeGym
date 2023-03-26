import React from "react";
import Card from "./Card";
import Footer from "./Footer";
import Header from "./Header";
import Jumbotron from "./Jumbotron";

function App() {
    return <>
      <Header/>
      <Jumbotron/>
      <div className="row">
         <Card/>
         <Card/>
      </div>
      <Footer/>
    </>;
}

export default App;
