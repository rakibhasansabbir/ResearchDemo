package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;

/**
 * @author rakib on 10/25/17
 * @project ResearchDemo
 */

@Entity
public class Registration {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;


    public Registration() {
    }

    public Registration(Student student, Section section, Semester semester) {
        this.student = student;
        this.section = section;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", student=" + student +
                ", section=" + section +
                ", semester=" + semester +
                '}';
    }
}
