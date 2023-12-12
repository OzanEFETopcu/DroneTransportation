function Delivery({ startingLatitude, startingLongitude, destLatitude, destLongitude, weight }) {

    return (
        <div className=''>
            <div style={{ display: 'flex', flexDirection: 'column', width: '100%', marginTop: '20px', marginLeft: '10px'}}>
                <p className=''>Starting Latitude: {startingLatitude}</p>
                <p className=''>Starting Longitude: {startingLongitude}</p>
                <p className=''>Destination Latitude: {destLatitude}</p>
                <p className=''>Destination Longitude: {destLongitude}</p>
                <p className=''>Weight: {weight}</p>
            </div>

        </div>
    );
}

export default Delivery;