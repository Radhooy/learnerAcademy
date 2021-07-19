package com.learnerAcademy.learnerAcademy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "subject")
@JsonIgnoreType
public class subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "subject_class",
            joinColumns = { @JoinColumn(name = "subject_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private List<classes> classes;


    public void addClass(classes tempClasses){
        if(classes == null)
            classes = new ArrayList<>();

        classes.add(tempClasses);
    }

    public subject() {
    }

    public subject(int id, String title, List<com.learnerAcademy.learnerAcademy.Model.classes> classes) {
        this.id = id;
        this.title = title;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<com.learnerAcademy.learnerAcademy.Model.classes> getClasses() {
        return classes;
    }

    public void setClasses(List<com.learnerAcademy.learnerAcademy.Model.classes> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", classes=" + classes +
                '}';
    }
}
