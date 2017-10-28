package bd.ac.seu.researchdemo.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rakib on 10/25/17
 * @project ResearchDemo
 */


@Entity
public class Section {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "courseCode")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "facultyId" )
    private Faculty faculty;
    private int section;

    @OneToMany
    @JoinColumn(name = "sectionId" )
    private Set<Attendance> attendanceSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "sectionId")
    private Set<Registration> registrationSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;


    public Section() {
    }

    public Section(Course course, Faculty faculty, int section, Set<Attendance> attendanceSet, Set<Registration> registrationSet, Semester semester) {
        this.course = course;
        this.faculty = faculty;
        this.section = section;
        this.attendanceSet = attendanceSet;
        this.registrationSet = registrationSet;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public Set<Attendance> getAttendanceSet() {
        return attendanceSet;
    }

    public void setAttendanceSet(Set<Attendance> attendanceSet) {
        this.attendanceSet = attendanceSet;
    }

    public Set<Registration> getRegistrationSet() {
        return registrationSet;
    }

    public void setRegistrationSet(Set<Registration> registrationSet) {
        this.registrationSet = registrationSet;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
