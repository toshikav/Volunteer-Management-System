public class Event {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventLocation;

    // Constructor
    public Event(int eventId,
                 String eventName,
                 String eventDate,
                 String eventLocation) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
    }

    // Getters
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    // Setters
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {

        return "\n--------------------------------------" +
                "\nEvent ID       : " + eventId +
                "\nEvent Name     : " + eventName +
                "\nEvent Date     : " + eventDate +
                "\nEvent Location : " + eventLocation +
                "\n--------------------------------------";
    }
}