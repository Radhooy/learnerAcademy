package com.learnerAcademy.learnerAcademy.Service;

import com.learnerAcademy.learnerAcademy.Model.users;

import java.util.List;

public interface usersService {

    void create (users user);
    void delete (users user);
    void deleteById(int id);
    List<users> listAll();
    users findById(int userId);
}
