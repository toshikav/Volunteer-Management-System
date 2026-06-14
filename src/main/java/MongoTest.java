import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoTest {

    public static void main(String[] args) {

        String uri =
            "mongodb+srv://nayepankhuser:jt8juzExrVx3!H!@cluster0.xnaqco4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database =
                    mongoClient.getDatabase("NayePankhDB");

            MongoCollection<Document> volunteers =
                    database.getCollection("volunteers");

            Document volunteer = new Document("id", 1)
                    .append("name", "Toshika")
                    .append("email", "toshika@example.com")
                    .append("hours", 25);

            volunteers.insertOne(volunteer);

            System.out.println("Volunteer added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}