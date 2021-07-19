package com.learnerAcademy.learnerAcademy.Repository;

import com.learnerAcademy.learnerAcademy.Model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersDao extends JpaRepository<users,Integer> {
}
