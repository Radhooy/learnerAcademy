package com.learnerAcademy.learnerAcademy.Repository;

import com.learnerAcademy.learnerAcademy.Model.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subjectDao extends JpaRepository<subject,Integer> {
}
