package bd.ac.seu.researchdemo.Models;


import javax.persistence.*;
@Entity
public class Registration {

    @Id
    @GeneratedValue
    private int id;
    private int semesterId;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;

    public Registration() {
    }

    public Registration(int id, int semesterId, Student student, Section section) {
        this.id = id;
        this.semesterId = semesterId;
        this.student = student;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
