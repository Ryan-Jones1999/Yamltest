package com.kainos.ea.service;

import com.kainos.ea.dao.UserDao;
import com.kainos.ea.model.User;

import java.sql.SQLException;

public class UserService {

    public UserDao userDao;

    public UserService(UserDao dao){
        this.userDao = dao;
    }

    public boolean registerUser(User user) throws SQLException {
        return userDao.register(user);
    }
}
