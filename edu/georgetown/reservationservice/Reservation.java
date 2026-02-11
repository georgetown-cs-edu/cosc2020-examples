package edu.georgetown.reservationservice;

import java.time.LocalDate;
import java.util.Vector;

public class Reservation {

    private Room room;

    private Vector<Guest> guests;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isPaid;

    public boolean isPaid() {
        return isPaid;
    }

    Reservation(Room room, Vector<Guest> guests, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.guests = guests;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Vector<Guest> getGuests() {
        return guests;
    }

}
