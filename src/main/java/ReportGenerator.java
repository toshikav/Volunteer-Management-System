import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    // Display Report on Console
    public static void generateReport(VolunteerManager manager) {

        System.out.println("\n========================================");
        System.out.println("      NAYEPANKH FOUNDATION REPORT");
        System.out.println("========================================");

        System.out.println("Total Volunteers   : "
                + manager.getTotalVolunteers());

        System.out.println("Present Volunteers : "
                + manager.getPresentVolunteers());

        System.out.println("Absent Volunteers  : "
                + manager.getAbsentVolunteers());

        System.out.println("========================================");
    }

    // Export Report to CSV
    public static void exportCSV(VolunteerManager manager) {

        String filePath = "../data/report.csv";

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Metric,Count");
            writer.newLine();

            writer.write("Total Volunteers,"
                    + manager.getTotalVolunteers());
            writer.newLine();

            writer.write("Present Volunteers,"
                    + manager.getPresentVolunteers());
            writer.newLine();

            writer.write("Absent Volunteers,"
                    + manager.getAbsentVolunteers());
            writer.newLine();

            System.out.println(
                    "\n✓ Report exported to report.csv successfully.");

        } catch (IOException e) {

            System.out.println(
                    "\nError exporting report: " + e.getMessage());
        }
    }
}