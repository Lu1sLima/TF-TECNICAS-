package com.project.app.CasosDeUso.Repositorios;

import com.project.app.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    User findByEmail(String email);

    User save(User user);

    User deleteUserById(Id id);

}