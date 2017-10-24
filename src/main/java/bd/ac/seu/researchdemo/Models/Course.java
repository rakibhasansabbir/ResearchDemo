package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Course {
    @Id
    @Size(max = 8)
    private String courseCode;
    @Size(max = 50)
    private String courseTitle;
    private int creditHours;

    @OneToMany
    @JoinColumn(name = "courseCode" )
    private Set<Section> sectionSet = new HashSet<>();

    public Course() {
    }

    public Course(String courseCode, String courseTitle, int creditHours) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public Set<Section> getSectionSet() {
        return sectionSet;
    }

    public void setSectionSet(Set<Section> sectionSet) {
        this.sectionSet = sectionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (creditHours != course.creditHours) return false;
        if (courseCode != null ? !courseCode.equals(course.courseCode) : course.courseCode != null) return false;
        if (courseTitle != null ? !courseTitle.equals(course.courseTitle) : course.courseTitle != null) return false;
        return sectionSet.equals(course.sectionSet);
    }

}
