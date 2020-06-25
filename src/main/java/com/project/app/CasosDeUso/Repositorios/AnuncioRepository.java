package com.project.app.CasosDeUso.Repositorios;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    Anuncio save(Anuncio anuncio);

    List<Anuncio> findAll();

    Optional<Anuncio> findById(Long id);

    List<Anuncio> findAllByUser(User user);

}
