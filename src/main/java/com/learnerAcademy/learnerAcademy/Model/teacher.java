package com.learnerAcademy.learnerAcademy.Model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "teacher")
public class teacher implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;



    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "teacher_id")
    private List<subject> subject;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "teacher_class",
            joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private List<classes> classes;


    public teacher() {
    }

    public teacher(int id, String first_name, String last_name, List<com.learnerAcademy.learnerAcademy.Model.subject> subject, List<com.learnerAcademy.learnerAcademy.Model.classes> classes) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.subject = subject;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<com.learnerAcademy.learnerAcademy.Model.subject> getSubject() {
        return subject;
    }

    public void setSubject(List<com.learnerAcademy.learnerAcademy.Model.subject> subject) {
        this.subject = subject;
    }

    public List<com.learnerAcademy.learnerAcademy.Model.classes> getClasses() {
        return classes;
    }

    public void setClasses(List<com.learnerAcademy.learnerAcademy.Model.classes> classes) {
        this.classes = classes;
    }

    public void addClass(classes tempClasses){
        if(classes == null)
            classes = new ArrayList<>();

        classes.add(tempClasses);
    }

    public void addSubject(subject tempSubject){
        if(subject == null)
            subject = new ArrayList<>();

        subject.add(tempSubject);
    }

    public boolean getCheckedClass(){
        return classes != null;
    }




}
