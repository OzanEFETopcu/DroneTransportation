
import './Drone.css';
import droneImage from './../assets/drone.png';

function Drone() {

    return (
        <div className='drone_box'>
            <img src={droneImage} className='drone_image' alt="droneImage" />
            <div style={{ display: 'flex', flexDirection: 'column', width: '100%', marginTop: '20px', marginLeft: '10px'}}>
                <p className='drone_info'>Name: </p>
                <p className='drone_info'>Status: </p>
                <p className='drone_info'>Capacity: </p>
            </div>

        </div>
    );
}

export default Drone;