import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class VolunteerManager {

    private static int idCounter = 1000;
    private final MongoCollection<Document> collection;

    public VolunteerManager() {

        this.collection = MongoDBManager.getVolunteerCollection();

        // Find highest existing ID from MongoDB
        Document lastVolunteer = collection.find()
                .sort(new Document("volunteerId", -1))
                .first();

        if (lastVolunteer != null) {
            Integer lastId = lastVolunteer.getInteger("volunteerId");

            if (lastId != null) {
                idCounter = lastId;
            }
        }
    }

    // =========================
    // ADD VOLUNTEER
    // =========================
    public void addVolunteer(Volunteer volunteer) {

        volunteer.setVolunteerId(++idCounter);

        Document doc = new Document()
                .append("volunteerId", volunteer.getVolunteerId())
                .append("name", volunteer.getName())
                .append("age", volunteer.getAge())
                .append("phoneNumber", volunteer.getPhoneNumber())
                .append("email", volunteer.getEmail())
                .append("skill", volunteer.getSkill())
                .append("assignedTask", volunteer.getAssignedTask())
                .append("attendanceStatus", volunteer.isAttendanceStatus());

        collection.insertOne(doc);

        System.out.println("✓ Volunteer added successfully!");
        System.out.println("Generated Volunteer ID: " +
                volunteer.getVolunteerId());
    }

    // =========================
    // VIEW ALL VOLUNTEERS
    // =========================
    public void viewAllVolunteers() {

        List<Volunteer> list = new ArrayList<>();

        for (Document doc : collection.find()) {
            list.add(documentToVolunteer(doc));
        }

        if (list.isEmpty()) {
            System.out.println("No volunteers found.");
            return;
        }

        System.out.println("\n========== ALL VOLUNTEERS ==========");

        for (Volunteer v : list) {
            System.out.println(v);
        }
    }

    // =========================
    // SEARCH BY ID
    // =========================
    public Volunteer searchById(int id) {

        Document doc = collection.find(
                Filters.eq("volunteerId", id))
                .first();

        if (doc == null) {
            return null;
        }

        return documentToVolunteer(doc);
    }

    // =========================
    // SEARCH BY NAME
    // =========================
    public List<Volunteer> searchByName(String name) {

        List<Volunteer> result = new ArrayList<>();

        for (Document doc : collection.find()) {

            String dbName = doc.getString("name");

            if (dbName != null &&
                    dbName.equalsIgnoreCase(name)) {

                result.add(documentToVolunteer(doc));
            }
        }

        return result;
    }

    // =========================
    // ASSIGN TASK
    // =========================
    public boolean assignTask(int id, String task) {

        UpdateResult result = collection.updateOne(
                Filters.eq("volunteerId", id),
                Updates.set("assignedTask", task)
        );

        return result.getModifiedCount() > 0;
    }

    // =========================
    // MARK ATTENDANCE
    // =========================
    public boolean markAttendance(int id, boolean status) {

        UpdateResult result = collection.updateOne(
                Filters.eq("volunteerId", id),
                Updates.set("attendanceStatus", status)
        );

        return result.getModifiedCount() > 0;
    }

    // =========================
    // REPORT METHODS
    // =========================
    public long getTotalVolunteers() {
        return collection.countDocuments();
    }

    public long getPresentVolunteers() {
        return collection.countDocuments(
                Filters.eq("attendanceStatus", true));
    }

    public long getAbsentVolunteers() {
        return collection.countDocuments(
                Filters.eq("attendanceStatus", false));
    }

    public long countBySkill(String skill) {
        return collection.countDocuments(
                Filters.eq("skill", skill));
    }

    // =========================
    // FILTER BY SKILL
    // =========================
    public List<Volunteer> filterBySkill(String skill) {

        List<Volunteer> result = new ArrayList<>();

        for (Document doc :
                collection.find(Filters.eq("skill", skill))) {

            result.add(documentToVolunteer(doc));
        }

        return result;
    }

    // =========================
    // GET ALL VOLUNTEERS
    // =========================
    public List<Volunteer> getVolunteers() {

        List<Volunteer> list = new ArrayList<>();

        for (Document doc : collection.find()) {
            list.add(documentToVolunteer(doc));
        }

        return list;
    }

    // =========================
    // DOCUMENT -> OBJECT
    // =========================
    private Volunteer documentToVolunteer(Document doc) {

        Integer id = doc.getInteger("volunteerId");
        Integer age = doc.getInteger("age");

        return new Volunteer(
                id != null ? id : 0,
                doc.getString("name"),
                age != null ? age : 0,
                doc.getString("phoneNumber"),
                doc.getString("email"),
                doc.getString("skill"),
                doc.getString("assignedTask") != null
                        ? doc.getString("assignedTask")
                        : "Not Assigned",
                doc.getBoolean("attendanceStatus") != null
                        ? doc.getBoolean("attendanceStatus")
                        : false
        );
    }
}