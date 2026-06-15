import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBManager {

    private static final String URI = System.getenv("MONGO_URI");
    private static final String DB_NAME = "NayePankhDB";

    private static MongoClient client;
    private static MongoDatabase database;

    // Initialize connection once
    static {
    System.out.println("URI Loaded = " + (URI != null));

    try {
        if (URI == null || URI.isEmpty()) {
            throw new RuntimeException("MongoDB URI is missing. Set MONGO_URI environment variable.");
        }

        client = MongoClients.create(URI);
        database = client.getDatabase(DB_NAME);

        if (database == null) {
            throw new RuntimeException("Failed to connect to MongoDB database.");
        }

        System.out.println("MongoDB Connected Successfully!");
    } catch (Exception e) {
        System.out.println("MongoDB Connection Failed: " + e.getMessage());
    }
}

    // Get collection safely
    public static MongoCollection<Document> getVolunteerCollection() {
        if (database == null) {
            throw new RuntimeException("Database not initialized. MongoDB connection failed.");
        }
        return database.getCollection("volunteers");
    }

    // Convert Mongo Document → Java Object
    public static List<Volunteer> getAllVolunteers() {

        if (database == null) {
            throw new RuntimeException("Cannot fetch volunteers. Database not connected.");
        }

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