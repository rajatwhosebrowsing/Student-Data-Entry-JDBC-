# Student Data Entry Java Application

This Java application allows CRUD (Create, Read, Update, Delete) operations on student records stored in a MySQL database. It includes functionality for adding new students, retrieving student details, updating marks, and deleting records. JDBC is used for database interaction.

## 📂 Project Structure

├── DBConnection.java // Manages DB connection ├── Main.java // Entry point, handles user interaction ├── Student.java // Represents the student entity ├── StudentDAO.java // Performs all DB operations

markdown
Copy
Edit

--- 

## 📄 Class & Method Descriptions

### 1. `DBConnection.java`

**Purpose**: Provides a reusable method to establish a connection with the MySQL database.

- **Method**:
  - `public static Connection getConnection()`:  
    Establishes and returns a JDBC connection to the database using hardcoded credentials.

---

### 2. `Student.java`

**Purpose**: Encapsulates student data.

- **Attributes**:
  - `int prn`: Unique identifier for each student.
  - `String name`: Student's full name.
  - `Date dob`: Date of birth.
  - `int[] marks`: An array of three integers representing marks in three subjects.

- **Constructor**:
  - `Student(int prn, String name, Date dob, int[] marks)`: Initializes all fields.

- **Getters**:
  - `getPrn()`, `getName()`, `getDob()`, `getMarks()`: Return the respective fields.

---

### 3. `StudentDAO.java`

**Purpose**: Contains all the SQL operations related to the `students` table.

- **Methods**:

  - `insertStudent(Student s)`:
    Inserts a new student record into the database.

  - `getAllStudents()`:
    Fetches all students from the database and returns them as a `List<Student>`.

  - `searchByPrn(int prn)`:
    Returns a single `Student` object matching the given PRN.

  - `searchByName(String nameQuery)`:
    Returns a list of students matching the provided name exactly.

  - `updateStudent(int prn, int[] newMarks)`:
    Updates the marks of the student with the specified PRN.

  - `deleteStudent(int prn)`:
    Deletes the student record with the specified PRN.

---

### 4. `Main.java`

**Purpose**: Provides a menu-driven interface to interact with the user and perform operations via the DAO class.

- **Features**:
  - Add a student
  - Display all students
  - Search by PRN
  - Search by Name
  - Search by Position in the list
  - Update student marks
  - Delete a student
  - Exit program

- **Approach**:
  Uses `Scanner` to take input, calls methods from `StudentDAO`, and displays formatted results.

---

## 🧰 Requirements

- Java JDK 8+
- MySQL server running with:
  - Database: `studentdb`
  - Table: `students(prn INT, name VARCHAR, dob DATE, mark1 INT, mark2 INT, mark3 INT)`
- JDBC Driver included in classpath

---

## ✅ How to Run

1. Ensure MySQL is running and the table is set up.
2. Compile all Java files:
   ```bash
   javac *.java
Run the application:

bash
Copy
Edit
java Main
📌 Author
Name: Rajat Dwivedi

PRN: 23070126100

Batch: B1

