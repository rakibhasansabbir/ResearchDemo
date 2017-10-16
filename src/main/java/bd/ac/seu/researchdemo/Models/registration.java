package bd.ac.seu.researchdemo.Models;


import javax.persistence.*;
@Entity
public class registration {

    @Id
    @GeneratedValue
    private  int id;

    private  int studentId;
    private  String courseCode;
    private String facultyInitials;
    private int semesterId;

    public registration(int studentId, String courseCode, String facultyInitials, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitials = facultyInitials;
        this.semesterId = semesterId;
    }

    public registration() {
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

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
