package bd.ac.seu.researchdemo.Models;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    private int facultyId;
    @Size(max = 5)
    private String facultyInitial;
    @Size(max = 30)
    private String facultyName;

    @OneToMany
    @JoinColumn(name = "facultyId" )
    private Set<Section> sectionSet = new HashSet<>();

    public Faculty() {
    }

    public Faculty(int facultyId, String facultyInitial, String facultyName) {
        this.facultyId = facultyId;
        this.facultyInitial = facultyInitial;
        this.facultyName = facultyName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyInitial() {
        return facultyInitial;
    }

    public void setFacultyInitial(String facultyInitial) {
        this.facultyInitial = facultyInitial;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;

        Faculty faculty = (Faculty) o;

        if (facultyId != faculty.facultyId) return false;
        if (facultyInitial != null ? !facultyInitial.equals(faculty.facultyInitial) : faculty.facultyInitial != null)
            return false;
        if (facultyName != null ? !facultyName.equals(faculty.facultyName) : faculty.facultyName != null) return false;
        return sectionSet.equals(faculty.sectionSet);
    }

    @Override
    public int hashCode() {
        int result = facultyId;
        result = 31 * result + (facultyInitial != null ? facultyInitial.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        result = 31 * result + sectionSet.hashCode();
        return result;
    }
}
