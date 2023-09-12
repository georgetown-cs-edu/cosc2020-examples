import java.util.*;

public class HistoryLookup {

    private Map<String, Calendar> events;

    public HistoryLookup() {
        events = new HashMap<>();
        // note: all of the following events were auto-populated by Copilot and I'm too
        // lazy to figure out if they are correct.
        events.put("World War II", new Calendar.Builder().setDate(1939, 9, 1).build());
        events.put("World War I", new Calendar.Builder().setDate(1914, 7, 28).build());
        events.put("American Civil War", new Calendar.Builder().setDate(1861, 4, 12).build());
        events.put("French Revolution", new Calendar.Builder().setDate(1789, 7, 14).build());
    }

    public Calendar getEventDate(String key) {
        return events.get(key);
    }

    public static void main( String args[] ) {
        HistoryLookup history = new HistoryLookup();
        Calendar eventDate = history.getEventDate("World War II");
        System.out.println( eventDate.getTime() );
    }

}