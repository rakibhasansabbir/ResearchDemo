package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class course {
    @Id
    @GeneratedValue
    private  int id;

    private String coursecode;
    private String coursetitle;
    private   String credits;

    @OneToMany
    @JoinColumn(name="course_id")
    private List<student> students = new ArrayList<>();


    @OneToMany
    @JoinColumn(name="teachers_id")
    private List<Teachers> teachers = new ArrayList<>();

    public course(String coursecode, String coursetitle, String credits) {
        this.coursecode = coursecode;
        this.coursetitle = coursetitle;
        this.credits = credits;
    }

    public course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String courseTitle) {
        this.coursetitle = coursetitle;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }
}
