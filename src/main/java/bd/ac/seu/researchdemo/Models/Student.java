package bd.ac.seu.researchdemo.Models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Student {
    @Id
    @Size(max = 15)
    private String studentId;
    @Size(max = 30)
    private String studentName;

    @OneToMany
    @JoinColumn(name = "studentId" )
    private Set<Attendance> attendanceSet = new HashSet<>();

    public Student() {
    }

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        return attendanceSet.equals(student.attendanceSet);
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + attendanceSet.hashCode();
        return result;
    }
}
