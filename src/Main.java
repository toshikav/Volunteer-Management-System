import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Admin Login
        if (!AdminLogin.login(scanner)) {
            System.out.println("\nExiting System...");
            return;
        }

        VolunteerManager manager = new VolunteerManager();
        EventManager eventManager = new EventManager();

        // Load saved volunteers
        ArrayList<Volunteer> loadedVolunteers = FileManager.loadVolunteers();

        for (Volunteer volunteer : loadedVolunteers) {
            manager.addVolunteer(volunteer);
        }

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("   NAYEPANKH FOUNDATION");
            System.out.println(" Volunteer Management System");
            System.out.println("========================================");

            System.out.println("1. Add Volunteer");
            System.out.println("2. View Volunteers");
            System.out.println("3. Search Volunteer");
            System.out.println("4. Assign Task");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Generate Report");
            System.out.println("7. Event Management");
            System.out.println("8. Save Data");
            System.out.println("9. Export Report CSV");
            System.out.println("10. Exit");

            System.out.print("\nEnter Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Volunteer ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Skill: ");
                    String skill = scanner.nextLine();

                    Volunteer volunteer = new Volunteer(
                            id,
                            name,
                            age,
                            phone,
                            email,
                            skill,
                            "Not Assigned",
                            false
                    );

                    manager.addVolunteer(volunteer);
                    break;

                case 2:

                    manager.viewAllVolunteers();
                    break;

                case 3:

                    System.out.print("Enter Volunteer ID: ");
                    int searchId =
                            Integer.parseInt(scanner.nextLine());

                    Volunteer found =
                            manager.searchById(searchId);

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Volunteer Not Found.");

                    break;

                case 4:

                    System.out.print("Volunteer ID: ");
                    int taskId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Task: ");
                    String task = scanner.nextLine();

                    if (manager.assignTask(taskId, task))
                        System.out.println("Task Assigned.");
                    else
                        System.out.println("Volunteer Not Found.");

                    break;

                case 5:

                    System.out.print("Volunteer ID: ");
                    int attendanceId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print(
                            "Present? (true/false): ");

                    boolean status =
                            Boolean.parseBoolean(
                                    scanner.nextLine());

                    if (manager.markAttendance(
                            attendanceId,
                            status))
                        System.out.println(
                                "Attendance Updated.");
                    else
                        System.out.println(
                                "Volunteer Not Found.");

                    break;

                case 6:

                    ReportGenerator.generateReport(manager);
                    break;

                case 7:

                    eventMenu(scanner, eventManager);
                    break;

                case 8:

                    FileManager.saveVolunteers(
                            manager.getVolunteers());

                    break;

                case 9:

                    ReportGenerator.exportCSV(manager);
                    break;

                case 10:

                    FileManager.saveVolunteers(
                            manager.getVolunteers());

                    System.out.println(
                            "\nThank You for Using the System!");

                    break;

                default:

                    System.out.println(
                            "\nInvalid Choice!");
            }

        } while (choice != 10);

        scanner.close();
    }

    // Event Menu
    private static void eventMenu(
            Scanner scanner,
            EventManager eventManager) {

        int choice;

        do {

            System.out.println("\n========== EVENT MANAGEMENT ==========");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Back");

            System.out.print("Enter Choice: ");

            choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Event ID: ");
                    int id =
                            Integer.parseInt(
                                    scanner.nextLine());

                    System.out.print("Event Name: ");
                    String name =
                            scanner.nextLine();

                    System.out.print("Event Date: ");
                    String date =
                            scanner.nextLine();

                    System.out.print("Location: ");
                    String location =
                            scanner.nextLine();

                    Event event =
                            new Event(
                                    id,
                                    name,
                                    date,
                                    location
                            );

                    eventManager.addEvent(event);
                    break;

                case 2:

                    eventManager.viewEvents();
                    break;

                case 3:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice!");
            }

        } while (true);
    }
}