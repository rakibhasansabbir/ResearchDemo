package bd.ac.seu.researchdemo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TestUpload {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    private byte[] file;

    public TestUpload() {
    }

    public TestUpload(byte[] file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
