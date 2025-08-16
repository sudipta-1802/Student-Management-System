# Student-Management-System(Java + MySQL)
This project is a Command-Line based Student Management System built with Java and integrated with MySQL database for persistent storage. It allows administrators to perform essential operations like adding, updating, deleting, and viewing student records efficiently.

## ✨Features
- Add new students
- View all students
- Update student details
- Delete students by ID
- Auto-increment student IDs
- MySQL database integration

---

## 🛠️Technologies Used
- **Java** (JDK 20+)
- **MySQL** (Workbench / Server)
- **JDBC Driver** (MySQL Connector/J)

---

## Requirements
- Java Development Kit (JDK) installed  
- MySQL Server and Workbench installed  
- MySQL Connector/J (JAR file added to project)

---
## 📂 Project Structure
```
Student-Management/
│
├── Main.java # Main program
├── student_db.sql
├── mysql-connector-j-x.x.x.jar
└── README.md # Project description
```

## 🛢Database Setup
1. Open MySQL Workbench.
2. Create the database(if needed):
```sql
  CREATE DATABASE student_db;
  USE student_db;
```
3.Create the table:
 ```sql
   CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);
 ```
## Project Setup
1. Clone or download this repository.
2. Add mysql-connector-j-x.x.x.jar to your project’s classpath.
3. Update database credentials in the Java file:
 ```java
   String url = "your_db_url";
   String user = "root";
   String password = "your_password";
 ```
4.Compile & run:
 ```java
   javac -cp .;mysql-connector-j-x.x.x.jar Main.java
   java -cp .;mysql-connector-j-x.x.x.jar Main
 ```
## Example Usage
```
  1. Add Student
  2. View Students
  3. Update Student
  4. Delete Student
  5. Exit
```
