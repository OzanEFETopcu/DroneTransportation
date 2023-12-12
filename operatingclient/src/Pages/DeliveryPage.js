import Delivery from "../components/Delivery";
import { useState, useEffect } from 'react';

function DeliveryPage() {

    const [data, setData] = useState(null);
    useEffect(() => {
        fetch('http://localhost:8000/dronora/flights')
            .then(response => response.json())
            .then(json => setData(json))
            .catch(error => console.error(error));
    }, [])

    return (
        <>
            <div>
                <div>
                    <h3 style={{ paddingLeft: '5vw' }}>Deliveries</h3>
                </div>
                <div>
                    {data && data.map((drone, i) => (
                        <Delivery
                            key={i} // Don't forget to add a unique key when mapping over elements
                            name={drone.name}
                            status={drone.status}
                            capacity={drone.capacity}
                        />
                    ))}
                </div>
            </div>
        </>
    );
}

export default DeliveryPage;