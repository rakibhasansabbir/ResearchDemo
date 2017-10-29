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

    public Semester(int semesterId, String semesterName, Set<Section> sectionSet, Set<Registration> registrationSet, Set<Attendance> attendanceSet) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.sectionSet = sectionSet;
        this.registrationSet = registrationSet;
        this.attendanceSet = attendanceSet;
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

    public Set<Section> getSectionSet() {
        return sectionSet;
    }

    public void setSectionSet(Set<Section> sectionSet) {
        this.sectionSet = sectionSet;
    }

    public Set<Registration> getRegistrationSet() {
        return registrationSet;
    }

    public void setRegistrationSet(Set<Registration> registrationSet) {
        this.registrationSet = registrationSet;
    }

    public Set<Attendance> getAttendanceSet() {
        return attendanceSet;
    }

    public void setAttendanceSet(Set<Attendance> attendanceSet) {
        this.attendanceSet = attendanceSet;
    }
}
