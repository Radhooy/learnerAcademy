package com.learnerAcademy.learnerAcademy.Repository;

import com.learnerAcademy.learnerAcademy.Model.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherDao extends JpaRepository<teacher,Integer> {
}
