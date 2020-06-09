package com.project.app.persistences;

import com.project.app.repositories.UserRepository;
import com.project.app.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Id id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) { return userRepository.save(user); }

    @Override
    public User deleteUserById(Id id)  { return userRepository.deleteUserById(id); }


}