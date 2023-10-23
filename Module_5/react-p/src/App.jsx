import { Route, Routes } from "react-router-dom";
import "./App.css";
import Navbar from "./components/NavBar/Navbar";
import GetGift from "./pages/UseState/GetGift";
import Login from "./pages/UseState/Login";
import ProductManagement from "./pages/UseState/ProductManagment";

function App() {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path="/" element={<GetGift/>}/>
                <Route path="/useState/getGift" element={<GetGift/>}/>
                <Route path="/useState/login" element={<Login/>}/>
                <Route path="/useState/prod-management" element={<ProductManagement/>}/>
            </Routes>
        </>
    );
}

export default App;
