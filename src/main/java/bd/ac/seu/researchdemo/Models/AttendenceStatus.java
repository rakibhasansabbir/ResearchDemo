package bd.ac.seu.researchdemo.Models;

/**
 * @author rakib on 10/25/17
 * @project ResearchDemo
 */
public enum AttendenceStatus {

    ABSENT("Absent"),
    PRESENT("Present");

    private final String Staus;

    AttendenceStatus(String staus) {
        Staus = staus;
    }
}
