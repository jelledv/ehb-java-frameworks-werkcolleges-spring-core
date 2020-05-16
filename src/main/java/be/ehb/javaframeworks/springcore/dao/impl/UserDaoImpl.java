package be.ehb.javaframeworks.springcore.dao.impl;

import be.ehb.javaframeworks.springcore.dao.api.UserDao;
import be.ehb.javaframeworks.springcore.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public void save(User entity) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try(PreparedStatement ps = c.prepareStatement("insert into users(name,email) values (?,?)")) {

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());

            ps.executeUpdate();
        }
    }

    @Override
    public Optional<User> findById(int entityId) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try(PreparedStatement ps = c.prepareStatement("select * from users where id=?")) {

            ps.setInt(1, entityId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                return Optional.of(new User(id, name, email));
            }

            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        Connection c = ConnectionSingleton.getConnection();

        try(Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery("select * from users")) {

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                User user = new User(id, name, email);
                users.add(user);
            }

            return users;
        }
    }
}
