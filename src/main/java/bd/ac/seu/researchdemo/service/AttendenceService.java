package bd.ac.seu.researchdemo.service;

import bd.ac.seu.researchdemo.Models.Attendance;

import java.util.ArrayList;
import java.util.List;

public class AttendenceService {


    private  int id;
    private String studentId;
    private String studentName;
    private  int totalPresent;
    private  int totalAbsent;
    private  int sectionId;
    private  int semesterId;

//   private List<AttendenceService> attendenceServiceList = new ArrayList<>();


    public AttendenceService(int id, String studentId, String studentName,
                             int totalPresent, int totalAbsent, int sectionId, int semesterId) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
        this.sectionId = sectionId;
        this.semesterId = semesterId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTotalPresent() {
        return totalPresent;
    }

    public void setTotalPresent(int totalPresent) {
        this.totalPresent = totalPresent;
    }

    public int getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(int totalAbsent) {
        this.totalAbsent = totalAbsent;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
