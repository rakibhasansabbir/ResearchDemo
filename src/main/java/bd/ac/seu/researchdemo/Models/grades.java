package bd.ac.seu.researchdemo.Models;


import javax.persistence.*;

@Entity
public class grades {
    @Id
    @GeneratedValue
    private  int id;

    private  int studentId;
    private  String courseCode;
    private String facultyInitials;
    private char grade;
    private int semesterId;

    public grades(int studentId, String courseCode, String facultyInitials,
                  char grade, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitials = facultyInitials;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public grades() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    public void setFacultyInitials(String facultyInitials) {
        this.facultyInitials = facultyInitials;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
