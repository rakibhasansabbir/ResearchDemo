package bd.ac.seu.researchdemo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private  int id;

    private String date;

    @ManyToOne
    private course course;

    @ManyToOne
    private Teachers teachers;

    @ManyToOne
    private student student;

    public Attendance() {
    }

    public Attendance(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public bd.ac.seu.researchdemo.Models.course getCourse() {
        return course;
    }

    public void setCourse(bd.ac.seu.researchdemo.Models.course course) {
        this.course = course;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public bd.ac.seu.researchdemo.Models.student getStudent() {
        return student;
    }

    public void setStudent(bd.ac.seu.researchdemo.Models.student student) {
        this.student = student;
    }
}
