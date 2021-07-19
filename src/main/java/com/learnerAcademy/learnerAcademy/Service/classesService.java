package com.learnerAcademy.learnerAcademy.Service;

import com.learnerAcademy.learnerAcademy.Model.classes;

import java.util.List;

public interface classesService {

    void create (classes classes);

    void delete (classes classes);
    void deleteById(int id);

    List<classes> listAll();

    classes findById(int class_id);



}
