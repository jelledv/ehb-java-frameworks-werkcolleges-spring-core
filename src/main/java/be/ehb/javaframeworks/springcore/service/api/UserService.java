package be.ehb.javaframeworks.springcore.service.api;

import be.ehb.javaframeworks.springcore.dto.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers() throws SQLException;

    Optional<User> findUserById(int id) throws SQLException;

    int getAmountOfUsers() throws SQLException;
}
