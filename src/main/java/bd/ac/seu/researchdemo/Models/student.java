package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;
@Entity
public class student {
    @Id
    @GeneratedValue
    private  int id;

    private  String studentId;
    private String studentName;

    public student(String studentId, String studentName) {

        this.studentId = studentId;
        this.studentName = studentName;
    }

    @ManyToOne
    private course course;

    public student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
