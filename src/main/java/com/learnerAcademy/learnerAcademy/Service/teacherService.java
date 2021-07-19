package com.learnerAcademy.learnerAcademy.Service;


import com.learnerAcademy.learnerAcademy.Model.teacher;

import java.util.List;

public interface teacherService {

    void create (teacher teacher);

    void delete (teacher teacher);
    void deleteById(int id);

    List<teacher> listAll();

    teacher findById(int teacherId);
}
