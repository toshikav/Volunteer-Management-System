import java.util.ArrayList;

public class EventManager {

    private ArrayList<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    // Add Event
    public void addEvent(Event event) {
        events.add(event);
        System.out.println("\n✓ Event added successfully!");
    }

    // View All Events
    public void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("\nNo events available.");
            return;
        }

        System.out.println("\n========== NGO EVENTS ==========");

        for (Event event : events) {
            System.out.println(event);
        }
    }

    // Search Event By ID
    public Event searchEvent(int id) {

        for (Event event : events) {

            if (event.getEventId() == id) {
                return event;
            }
        }

        return null;
    }

    // Total Events
    public int getTotalEvents() {
        return events.size();
    }
}