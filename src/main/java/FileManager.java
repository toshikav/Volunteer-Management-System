import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "volunteers.dat";

    // SAVE
    public static void saveVolunteers(List<Volunteer> volunteers) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(new ArrayList<>(volunteers));
            System.out.println("Data saved successfully!");

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD
    public static ArrayList<Volunteer> loadVolunteers() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Volunteer>) in.readObject();

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}