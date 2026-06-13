public class Volunteer {
    private int volunteerId;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private String skill;
    private String assignedTask;
    private boolean attendanceStatus;

    // Constructor
    public Volunteer(int volunteerId, String name, int age,
                     String phoneNumber, String email,
                     String skill, String assignedTask,
                     boolean attendanceStatus) {

        this.volunteerId = volunteerId;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.skill = skill;
        this.assignedTask = assignedTask;
        this.attendanceStatus = attendanceStatus;
    }

    // Getters and Setters
    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }

    public boolean isAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(boolean attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Override
    public String toString() {
        return String.format(
                "\n--------------------------------------------------" +
                "\nVolunteer ID : %d" +
                "\nName         : %s" +
                "\nAge          : %d" +
                "\nPhone        : %s" +
                "\nEmail        : %s" +
                "\nSkill        : %s" +
                "\nAssigned Task: %s" +
                "\nAttendance   : %s" +
                "\n--------------------------------------------------",
                volunteerId,
                name,
                age,
                phoneNumber,
                email,
                skill,
                assignedTask,
                attendanceStatus ? "Present" : "Absent"
        );
    }

    // Convert object to file format
    public String toFileString() {
        return volunteerId + "," +
                name + "," +
                age + "," +
                phoneNumber + "," +
                email + "," +
                skill + "," +
                assignedTask + "," +
                attendanceStatus;
    }
}