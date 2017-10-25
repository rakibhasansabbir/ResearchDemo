package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rakib on 10/25/17
 * @project ResearchDemo
 */
@Entity
public class Semester {

    @Id
    private int semesterId;
    private String semesterName;

    @OneToMany
    @JoinColumn(name = "semesterId")
    Set<Section> sectionSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "semesterId")
    Set<Registration> registrationSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "semesterId")
    Set<Attendance> attendanceSet = new HashSet<>();

    public Semester() {
    }

    public Semester(int semesterId, String semesterName) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }
}
