package com.project.app.CasosDeUso.Repositorios;

import com.project.app.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Id id);

    User findByEmail(String email);

    User save(User user);

    User deleteUserById(Id id);

}