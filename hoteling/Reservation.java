package hoteling;

import java.time.LocalDate;

public class Reservation {

    private RentalSpace space;
    private LocalDate start;
    private LocalDate end;



    Reservation(RentalSpace space, LocalDate start, LocalDate end) {
        this.space = space;
        this.start = start;
        this.end = end;
    }

    public RentalSpace getSpace() {
        return space;
    }

    public void setSpace(RentalSpace space) {
        this.space = space;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }


    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }


}
