package bd.ac.seu.researchdemo.Models;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @author rakib on 10/25/17
 * @project ResearchDemo
 */

@Entity
public class Attendance {
    @Id
    @GeneratedValue
    private  int id;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;

    @Enumerated(EnumType.STRING)
    private  Type type;

    @Enumerated(EnumType.STRING)
    private  AttendenceStatus attendenceStatus;


    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;


    public Attendance() {
    }

    public Attendance(Student student, Section section, Type type, AttendenceStatus attendenceStatus,
                      LocalDateTime dateTime, Semester semester) {
        this.student = student;
        this.section = section;
        this.type = type;
        this.attendenceStatus = attendenceStatus;
        this.dateTime = dateTime;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public AttendenceStatus getAttendenceStatus() {
        return attendenceStatus;
    }

    public void setAttendenceStatus(AttendenceStatus attendenceStatus) {
        this.attendenceStatus = attendenceStatus;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
