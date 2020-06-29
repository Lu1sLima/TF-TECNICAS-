package com.project.app.Interfaces.RepositoriosImpl;

import com.project.app.CasosDeUso.Repositorios.UserRepository;
import com.project.app.Entidades.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
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