package edu.georgetown.reservationservice;

public class Suite extends Room {
    Suite( int maxOccupancy ) throws InvalidRoomException {
        if( maxOccupancy < 1 ) {
            throw new InvalidRoomException();
        }
        this.maxOccupancy = maxOccupancy;
    }
}
