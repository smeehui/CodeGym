import React, { useState } from "react";

const gifts = ["Gấu bông", "Bóng bay", "Siêu nhân", "Xe hơi", "Máy bay"];
function GetGift() {
    const [gift, setGift] = useState("");

    const handleGetGift = () => {
        setGift((gift) => {
            while (true) {
                let randIndex = Math.round(Math.random() * (gifts.length - 1));
                if (gift === gifts[randIndex]) continue;
                setGift(gifts[randIndex]);
                break;
            }
        });
    };

    return (
        <div>
            <div style={{ marginBottom: "10px" }}>
                {gifts.map((gift) => (
                    <span
                        style={{ border: "1px solid black", padding: "5px" }}
                        key={gift}
                    >
                        {gift}
                    </span>
                ))}
            </div>
            <p>Click to get your gift</p>
            <button onClick={handleGetGift}>Get</button>
            {gift && <p>Your gift is {gift}</p>}
        </div>
    );
}

export default GetGift;
