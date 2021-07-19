package com.learnerAcademy.learnerAcademy.Service.impl;

import com.learnerAcademy.learnerAcademy.Model.student;
import com.learnerAcademy.learnerAcademy.Repository.studentDao;
import com.learnerAcademy.learnerAcademy.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentDao studentDao;

    @Override
    public void create(student student) {
        studentDao.save(student);
    }

    @Override
    public void delete(student student) {
    	studentDao.delete(student);
    }

    @Override
    public void deleteById(int id) {
        studentDao.deleteById(id);
        }

    @Override
    public List<student> listAll() {
        return studentDao.findAll();
    }

    @Override
    public student findById(int studentId) {
        Optional<student> student = studentDao.findById(studentId);
        return student.get();
    }
}
