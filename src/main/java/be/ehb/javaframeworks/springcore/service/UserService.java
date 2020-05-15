package be.ehb.javaframeworks.springcore.service;

import be.ehb.javaframeworks.springcore.dao.UserDao;
import be.ehb.javaframeworks.springcore.dto.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }

    public Optional<User> findUserById(int id) throws SQLException {
        return userDao.findById(id);
    }

    public int getAmountOfUsers() throws SQLException {
        return userDao.findAll().size();
    }
}
