import java.util.ArrayList;

public class VolunteerManager {

    private ArrayList<Volunteer> volunteers;

    public VolunteerManager() {
        volunteers = new ArrayList<>();
    }

    public ArrayList<Volunteer> getVolunteers() {
        return volunteers;
    }

    // Add Volunteer
    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        System.out.println("\n✓ Volunteer added successfully!");
    }

    // View All Volunteers
    public void viewAllVolunteers() {

        if (volunteers.isEmpty()) {
            System.out.println("\nNo volunteers found.");
            return;
        }

        System.out.println("\n========== ALL VOLUNTEERS ==========");

        for (Volunteer volunteer : volunteers) {
            System.out.println(volunteer);
        }
    }

    // Search by ID
    public Volunteer searchById(int id) {

        for (Volunteer volunteer : volunteers) {

            if (volunteer.getVolunteerId() == id) {
                return volunteer;
            }
        }

        return null;
    }

    // Search by Name
    public ArrayList<Volunteer> searchByName(String name) {

        ArrayList<Volunteer> result = new ArrayList<>();

        for (Volunteer volunteer : volunteers) {

            if (volunteer.getName().equalsIgnoreCase(name)) {
                result.add(volunteer);
            }
        }

        return result;
    }

    // Assign Task
    public boolean assignTask(int id, String task) {

        Volunteer volunteer = searchById(id);

        if (volunteer != null) {
            volunteer.setAssignedTask(task);
            return true;
        }

        return false;
    }

    // Mark Attendance
    public boolean markAttendance(int id, boolean status) {

        Volunteer volunteer = searchById(id);

        if (volunteer != null) {
            volunteer.setAttendanceStatus(status);
            return true;
        }

        return false;
    }

    // Count Total Volunteers
    public int getTotalVolunteers() {
        return volunteers.size();
    }

    // Count Present Volunteers
    public int getPresentVolunteers() {

        int count = 0;

        for (Volunteer volunteer : volunteers) {

            if (volunteer.isAttendanceStatus()) {
                count++;
            }
        }

        return count;
    }

    // Count Absent Volunteers
    public int getAbsentVolunteers() {

        int count = 0;

        for (Volunteer volunteer : volunteers) {

            if (!volunteer.isAttendanceStatus()) {
                count++;
            }
        }

        return count;
    }

    // Count Volunteers By Skill
    public int countBySkill(String skill) {

        int count = 0;

        for (Volunteer volunteer : volunteers) {

            if (volunteer.getSkill().equalsIgnoreCase(skill)) {
                count++;
            }
        }

        return count;
    }

    // Filter Volunteers By Skill
    public ArrayList<Volunteer> filterBySkill(String skill) {

        ArrayList<Volunteer> filtered = new ArrayList<>();

        for (Volunteer volunteer : volunteers) {

            if (volunteer.getSkill().equalsIgnoreCase(skill)) {
                filtered.add(volunteer);
            }
        }

        return filtered;
    }
}