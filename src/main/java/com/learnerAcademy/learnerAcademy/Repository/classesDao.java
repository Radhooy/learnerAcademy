package com.learnerAcademy.learnerAcademy.Repository;

import com.learnerAcademy.learnerAcademy.Model.classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface classesDao extends JpaRepository<classes,Integer> {



}
