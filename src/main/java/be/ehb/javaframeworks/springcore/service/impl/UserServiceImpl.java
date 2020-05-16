package be.ehb.javaframeworks.springcore.service.impl;

import be.ehb.javaframeworks.springcore.dao.api.UserDao;
import be.ehb.javaframeworks.springcore.dto.User;
import be.ehb.javaframeworks.springcore.service.api.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) throws SQLException {
        return userDao.findById(id);
    }

    @Override
    public int getAmountOfUsers() throws SQLException {
        return userDao.findAll().size();
    }
}
