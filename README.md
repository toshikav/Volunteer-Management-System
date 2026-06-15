NayePankh Volunteer System

A Java-based Volunteer Management System integrated with MongoDB Atlas.  
This project manages volunteer data using CRUD operations with a DAO-based backend architecture.

------------------------------------------------------------

Features

- Admin Login System
- MongoDB Atlas Integration
- Add Volunteers
- View Volunteers
- DAO Layer Architecture
- Environment Variable Based Configuration
- Modular Java Code Structure

------------------------------------------------------------

Tech Stack

- Java
- MongoDB Atlas
- Maven
- MongoDB Java Driver

------------------------------------------------------------

Project Structure

src/main/java/

- Main.java
- MongoDBManager.java
- VolunteerDAO.java
- Volunteer.java
- VolunteerManager.java
- FileManager.java

------------------------------------------------------------

Setup Instructions

1. Clone the repository

git clone https://github.com/your-username/NayePankhVolunteerSystem.git

2. Set environment variable

MONGO_URI=your_mongodb_connection_string

3. Run the project

mvn clean compile exec:java

------------------------------------------------------------

Security

- No hardcoded credentials
- MongoDB URI stored in environment variables
- .gitignore configured to prevent sensitive data exposure

------------------------------------------------------------

Learning Outcomes

- Java backend development
- MongoDB integration
- DAO design pattern
- Environment variable handling
- Maven project structure
- Debugging real-world issues

------------------------------------------------------------

Future Improvements

- JavaFX GUI
- Role-based authentication
- REST API using Spring Boot
- Web dashboard
- Attendance tracking system

------------------------------------------------------------

Author

Toshika Verma
B.Tech Student | Java Developer | Backend Enthusiast