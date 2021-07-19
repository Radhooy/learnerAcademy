package com.learnerAcademy.learnerAcademy.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "classes")
public class classes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private List<student> student;

    @ManyToMany(mappedBy = "classes")
    private List<teacher> teachers;

    @ManyToMany(mappedBy = "classes")
    private List<subject> subject;


    public classes() {
    }

    public classes(int id, String name, List<com.learnerAcademy.learnerAcademy.Model.student> student, List<teacher> teachers, List<com.learnerAcademy.learnerAcademy.Model.subject> subject) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.teachers = teachers;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.learnerAcademy.learnerAcademy.Model.student> getStudent() {
        return student;
    }

    public void setStudent(List<com.learnerAcademy.learnerAcademy.Model.student> student) {
        this.student = student;
    }

    public List<teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<teacher> teachers) {
        this.teachers = teachers;
    }

    public List<com.learnerAcademy.learnerAcademy.Model.subject> getSubject() {
        return subject;
    }

    public void setSubject(List<com.learnerAcademy.learnerAcademy.Model.subject> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", teachers=" + teachers +
                ", subject=" + subject +
                '}';
    }


}
