import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBManager {

    
    private static final String URI =
       private static final String CONNECTION_STRING =
        "YOUR_MONGODB_CONNECTION_STRING";

    private static final String DB_NAME = "NayePankhDB";

    private static MongoClient client;
    private static MongoDatabase database;

    // Initialize connection once
    static {
        try {
            client = MongoClients.create(URI);
            database = client.getDatabase(DB_NAME);
            System.out.println("MongoDB Connected Successfully!");
        } catch (Exception e) {
            System.out.println("MongoDB Connection Failed: " + e.getMessage());
        }
    }

    // Get collection
    public static MongoCollection<Document> getVolunteerCollection() {
        return database.getCollection("volunteers");
    }

    // Convert Mongo Document → Java Object
    public static List<Volunteer> getAllVolunteers() {

        List<Volunteer> list = new ArrayList<>();

        for (Document doc : getVolunteerCollection().find()) {
        Volunteer v = new Volunteer(
        doc.getInteger("volunteerId", 0),
        doc.getString("name"),
        doc.getInteger("age", 0),
        doc.getString("phoneNumber"),
        doc.getString("email"),
        doc.getString("skill"),
        doc.getString("assignedTask"),
        doc.getBoolean("attendanceStatus", false)
    );

            list.add(v);
        }

        return list;
    }
}