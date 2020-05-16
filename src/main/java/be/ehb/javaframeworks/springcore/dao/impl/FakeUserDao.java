package be.ehb.javaframeworks.springcore.dao.impl;

import be.ehb.javaframeworks.springcore.dao.api.UserDao;
import be.ehb.javaframeworks.springcore.dto.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("development")
public class FakeUserDao implements UserDao, InitializingBean {

    private Map<Integer, User> hashMapDb = new HashMap<>();

    @Override
    public void save(User entity) {
        hashMapDb.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findById(int entityId) {
        return Optional.of(hashMapDb.get(entityId));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(hashMapDb.values());
    }

    // Doordat @PostConstruct verwijderd is, gebruiken we de interface @InitializingBean om onze database te vullen
    @Override
    public void afterPropertiesSet() {
        hashMapDb.put(1, new User(1, "Jan Parlo", "jan.parlo@gmail.com"));
        hashMapDb.put(2, new User(2, "Erik Meier", "erik.meier@gmail.com"));
    }
}
