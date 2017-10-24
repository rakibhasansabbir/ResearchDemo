package bd.ac.seu.researchdemo.Models;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rakib on 10/24/17
 * @project ResearchDemo
 */
public enum Type {

    AB ("Absent"),
    p("Present");

    private  String ClassStatus;
    private  String ExamStatus;
    private  String Staus;


    Type(String staus) {
        Staus = staus;
    }

    public String getClassStatus() {
        return ClassStatus;
    }

    public void setClassStatus(String classStatus) {
        ClassStatus = classStatus;
    }

    public String getExamStatus() {
        return ExamStatus;
    }

    public void setExamStatus(String examStatus) {
        ExamStatus = examStatus;
    }

    public String getStaus() {
        return Staus;
    }

    public void setStaus(String staus) {
        Staus = staus;
    }

    @Override
    public String toString() {
        return  Staus;
    }
}
