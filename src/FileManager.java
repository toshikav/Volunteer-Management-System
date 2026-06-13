import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH = "../data/volunteers.txt";

    // Save Volunteers
    public static void saveVolunteers(ArrayList<Volunteer> volunteers) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Volunteer volunteer : volunteers) {
                writer.write(volunteer.toFileString());
                writer.newLine();
            }

            System.out.println("\n✓ Data saved successfully.");

        } catch (IOException e) {
            System.out.println("\nError saving data: " + e.getMessage());
        }
    }

    // Load Volunteers
    public static ArrayList<Volunteer> loadVolunteers() {

        ArrayList<Volunteer> volunteers = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return volunteers;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 8) {

                    Volunteer volunteer = new Volunteer(
                            Integer.parseInt(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            data[3],
                            data[4],
                            data[5],
                            data[6],
                            Boolean.parseBoolean(data[7])
                    );

                    volunteers.add(volunteer);
                }
            }

        } catch (Exception e) {
            System.out.println("\nError loading data: " + e.getMessage());
        }

        return volunteers;
    }
}