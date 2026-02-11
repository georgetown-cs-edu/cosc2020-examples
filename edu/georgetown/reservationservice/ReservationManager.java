package edu.georgetown.reservationservice;

import java.time.LocalDate;
import java.util.Vector;

public class ReservationManager {

    private Vector<Room> rooms;
    private Vector<Reservation> reservations;

    ReservationManager() {
        rooms = new Vector<Room>();
        reservations = new Vector<Reservation>();
    }

    public void registerRoom(Room room) {
        rooms.add(room);
    }


    /**
     * checks whether the room is available and if it can fit the number of requested guests
     * @param room the room to check
     * @param start the start date
     * @param end the end date
     * @param numGuests the number of guests
     * @return true, iff the room is available and can hold the provided number of guests
     */
    public boolean isRoomAvailable(Room room, LocalDate start, LocalDate end, int numGuests) {

        if (room.getMaxOccupancy() < numGuests) {
            return false;
        }

        for (Reservation r : reservations) {
            // if the start and end date (the parameters) overlaps with this reservation,
            // then return "false" (because the room isn't available)
            if (r.getRoom() == room) {
                if (start.isAfter(r.getStartDate()) && start.isBefore(r.getEndDate())) {
                    return false;
                }
                if (end.isAfter(r.getStartDate()) && end.isBefore(r.getEndDate())) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Creates a new reservation for a room with the specified guests during the given date range.
     * 
     * @param room the Room to be reserved
     * @param start the start date of the reservation (inclusive)
     * @param end the end date of the reservation (inclusive)
     * @param guests a Vector of Guest objects making the reservation
     * @throws CannotReserveException if the room is not available for the specified dates
     *         or if the number of guests exceeds the room's capacity
     */
    public void makeReservation(Room room, LocalDate start, LocalDate end, Vector<Guest> guests)
            throws CannotReserveException {

        if (isRoomAvailable(room, start, end, guests.size()) == false) {
            throw new CannotReserveException();
        }

        Reservation newReservation = new Reservation(room, guests, start, end);
        reservations.add(newReservation);
    }

    public static void main(String args[]) {

        ReservationManager mgr = new ReservationManager();

        Room r1 = null;

        try {
            Suite s1 = new Suite(10);
            r1 = new Suite(3);
            Room r2 = new Suite(2);
            Room r3 = new Suite(1);
            mgr.registerRoom(s1);
            mgr.registerRoom(r1);
            mgr.registerRoom(r2);
            mgr.registerRoom(r3);

        } catch (InvalidRoomException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Guest micah = new Guest();
        micah.setName("Micah");
        Vector<Guest> guests = new Vector<Guest>();
        guests.add(micah);

        boolean avail = mgr.isRoomAvailable(r1,
                LocalDate.of(2026, 2, 11),
                LocalDate.of(2026, 2, 15),
                1);

        try {
            mgr.makeReservation(r1, LocalDate.of(2026, 2, 11),
                    LocalDate.of(2026, 2, 15),
                    guests);
            mgr.makeReservation(r1, LocalDate.of(2026, 2, 5),
                    LocalDate.of(2026, 2, 12),
                    guests);                    
        } catch (CannotReserveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                

        System.out.println(avail);


    }

}
