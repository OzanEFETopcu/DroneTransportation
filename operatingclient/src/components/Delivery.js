function Delivery({ startingPoint, destination, weight }) {

    return (
        <div className=''>
            <div style={{ display: 'flex', flexDirection: 'column', width: '100%', marginTop: '20px', marginLeft: '10px'}}>
                <p className=''>Starting Point: {startingPoint}</p>
                <p className=''>Destination: {destination}</p>
                <p className=''>Weight: {weight}</p>
            </div>

        </div>
    );
}

export default Delivery;