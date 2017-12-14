package bd.ac.seu.researchdemo.Models;

/**
 * @author rakib on 10/24/17
 * @project ResearchDemo
 */
public enum Type {

    CLASS("Class"),
    MAKEUP("Makeup");

    private final String Type;

    Type(String staus) {
        Type = staus;
    }

    public String getType() {
        return Type;
    }
}
