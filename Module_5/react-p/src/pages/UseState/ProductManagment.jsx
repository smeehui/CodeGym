import React, { useState } from "react";

function ProductManagement() {
    const [products, setProducts] = useState([]);
    const [product, setProduct] = useState("");

    const handleInput = (e) => {
        setProduct(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setProducts([...products, product]);
        setProduct("");
    };
    const handleRemove = (pos) => {
        setProducts((prev) => prev.filter((prod, index) => index != pos));
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" value={product} onChange={handleInput} />
                <button type="submit">Add</button>
            </form>
            <ul>
                {!products.length ? (
                    <p>Không có sản phẩm nào</p>
                ) : (
                    products.map((prod, index) => (
                        <li key={index} style={{ width: "200px" }}>
                            {prod}
                            <span
                                style={{
                                    cursor: "pointer",
                                    color: "red",
                                    float: "right",
                                    fontWeight: "bolder"
                                }}
                                onClick={() => handleRemove(index)}
                            >
                                &times;
                            </span>
                        </li>
                    ))
                )}
            </ul>
        </div>
    );
}

export default ProductManagement;
