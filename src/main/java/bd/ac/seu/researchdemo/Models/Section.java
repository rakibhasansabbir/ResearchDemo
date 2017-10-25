package bd.ac.seu.researchdemo.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private int sectionId;

    @OneToMany
    @JoinColumn(name = "sectionId" )
    private Set<Attendance> attendanceSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;


    public Section() {
    }

    public Section(int id, Course course, Faculty faculty, int sectionId) {
        this.id = id;
        this.course = course;
        this.faculty = faculty;
        this.sectionId = sectionId;
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

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public Set<Attendance> getAttendanceSet() {
        return attendanceSet;
    }

    public void setAttendanceSet(Set<Attendance> attendanceSet) {
        this.attendanceSet = attendanceSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;

        Section section = (Section) o;

        if (id != section.id) return false;
        if (sectionId != section.sectionId) return false;
        if (course != null ? !course.equals(section.course) : section.course != null) return false;
        if (faculty != null ? !faculty.equals(section.faculty) : section.faculty != null) return false;
        return attendanceSet.equals(section.attendanceSet);
    }

}
