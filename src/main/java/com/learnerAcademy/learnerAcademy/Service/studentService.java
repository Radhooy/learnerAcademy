package com.learnerAcademy.learnerAcademy.Service;

import com.learnerAcademy.learnerAcademy.Model.student;

import java.util.List;

public interface studentService {


    void create (student student);

    void delete (student student);
    void deleteById(int id);

    List<student> listAll();

    student findById(int studentId);
}
