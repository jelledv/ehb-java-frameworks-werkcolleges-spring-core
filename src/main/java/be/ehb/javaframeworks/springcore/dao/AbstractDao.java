package be.ehb.javaframeworks.springcore.dao;

import be.ehb.javaframeworks.springcore.dto.BaseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AbstractDao<T extends BaseDto> {

    void save(T entity) throws SQLException;

    Optional<T> findById(int entityId) throws SQLException;

    List<T> findAll() throws SQLException;
}
