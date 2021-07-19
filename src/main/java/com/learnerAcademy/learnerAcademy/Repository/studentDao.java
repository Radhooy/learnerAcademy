package com.learnerAcademy.learnerAcademy.Repository;

import com.learnerAcademy.learnerAcademy.Model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentDao extends JpaRepository<student,Integer> {
}
