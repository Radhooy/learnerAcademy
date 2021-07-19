package com.learnerAcademy.learnerAcademy.Service.impl;

import com.learnerAcademy.learnerAcademy.Model.subject;
import com.learnerAcademy.learnerAcademy.Repository.subjectDao;
import com.learnerAcademy.learnerAcademy.Service.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class subjectServiceImpl implements subjectService {

    @Autowired
    private subjectDao subjectDao;

    @Override
    public void create(subject subject) {
        subjectDao.save(subject);
    }

    @Override
    public void delete(subject subject) {
        subjectDao.delete(subject);
    }

    @Override
    public void deleteById(int id) {
        subjectDao.deleteById(id);
    }

    @Override
    public List<subject> listAll() {
        return subjectDao.findAll();
    }

    @Override
    public subject findById(int id) {
        Optional<subject> temp = subjectDao.findById(id);
        return temp.get();
    }
}
