// Represents a Student entity
public class Student {
    private int prn;
    private String name;
    private java.sql.Date dob;
    private int[] marks;  // stores three subject marks

    // Constructor 
    public Student(int prn, String name, java.sql.Date dob, int[] marks) {
        this.prn   = prn;
        this.name  = name;
        this.dob   = dob;
        this.marks = marks;
    }

        // Getters
        public int getPrn()           { return prn; }
        public String getName()       { return name; }
        public java.sql.Date getDob() { return dob; }
        public int[] getMarks()       { return marks; }
    }
    


