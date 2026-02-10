package hoteling;

import java.time.LocalDate;
import java.util.Vector;

public class ReservationManager {

    private Vector<RentalSpace> allSpaces;
    private Vector<Reservation> reservations;

    ReservationManager() {
        allSpaces = new Vector<RentalSpace>();
        reservations = new Vector<Reservation>();
    }

    public void addProperty(RentalSpace space) {
        allSpaces.add(space);
    }

    public boolean hasOccupancy(RentalSpace space, LocalDate start, LocalDate end, int persons) {
        if (space.getMaxOccupancy() < persons) {
            return false;
        }

        for (Reservation res : reservations) {
            if (res.getSpace() == space) {

                if (start.isAfter(res.getStart()) && start.isBefore(res.getEnd())) {
                    return false;
                }
                if (end.isAfter(res.getStart()) && end.isBefore(res.getEnd())) {
                    return false;
                }
            }
        }

        return true;
    }

    public void makeReservation(RentalSpace space, LocalDate start, LocalDate end, int persons)
            throws CannotMakeReservationException {
        if (!hasOccupancy(space, start, end, persons)) {
            throw new CannotMakeReservationException();
        }
        reservations.add( new Reservation(space, start, end) );
        return;
    }

    public static void main(String args[]) {
        HotelRoom room1 = new HotelRoom(5);
        HotelRoom room2 = new HotelRoom(4);

        ReservationManager mgr = new ReservationManager();
        mgr.addProperty(room1);
        mgr.addProperty(room2);

        try {
            mgr.makeReservation(room1,
                    LocalDate.of(2026, 2, 5),
                    LocalDate.of(2026, 2, 11),
                    3);
            mgr.makeReservation(room2,
                    LocalDate.of(2026, 2, 5),
                    LocalDate.of(2026, 2, 11),
                    3);
            mgr.makeReservation(room1,
                    LocalDate.of(2026, 2, 3),
                    LocalDate.of(2026, 2, 6),
                    3);

        } catch (CannotMakeReservationException e) {
            e.printStackTrace();
        }

    }

}
