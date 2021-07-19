package com.learnerAcademy.learnerAcademy.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;


    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private classes classes;


    public student() {
    }

    public student(int id, String first_name, String last_name, com.learnerAcademy.learnerAcademy.Model.classes classes) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public com.learnerAcademy.learnerAcademy.Model.classes getClasses() {
        return classes;
    }

    public void setClasses(com.learnerAcademy.learnerAcademy.Model.classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", classes=" + classes +
                '}';
    }
}
