import Drone from "../components/Drone";
import { useState, useEffect } from 'react';

function DronePage() {

    const [data, setData] = useState(null);
    useEffect(() => {
        fetch('http://localhost:8000/dronora/drones')
            .then(response => response.json())
            .then(json => setData(json))
            .catch(error => console.error(error));
    }, [])

    return (
        <>
            <div>
                <div>
                    <h3 style={{ paddingLeft: '5vw' }}>Drones</h3>
                </div>
                <div>
                    {data && data.map((drone, i) => (
                        <Drone
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

export default DronePage;