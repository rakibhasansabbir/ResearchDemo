package bd.ac.seu.researchdemo.Models;


import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Entity
public class ClassAnnouncements {

    @Id
    @GeneratedValue
    private int id;
    private String announcements;
    private File file;
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime postDateTime;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private Section section;

    public ClassAnnouncements() {
    }

    public ClassAnnouncements(String announcements, File file,
                              LocalDateTime postDateTime, Section section) {
        this.announcements = announcements;
        this.file = file;
        this.postDateTime = postDateTime;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(String announcements) {
        this.announcements = announcements;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
