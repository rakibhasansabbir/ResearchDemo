package bd.ac.seu.researchdemo.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teachers {

    @Id
    @GeneratedValue
    private  int id;
    private String Teacherinitial;
    private  String TeacherName;

    public Teachers(String teacherinitial, String teacherName) {
        Teacherinitial = teacherinitial;
        TeacherName = teacherName;
    }

    @ManyToOne
    private course course;

    public Teachers() {
    }

    public String getTeacherinitial() {
        return Teacherinitial;
    }

    public void setTeacherinitial(String teacherinitial) {
        Teacherinitial = teacherinitial;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
