package com.project.app.Interfaces.RepositoriosImpl;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.User;
import com.project.app.CasosDeUso.Repositorios.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class AnuncioRepositoryImpl implements AnuncioRepository {
    @Autowired
    AnuncioRepository anuncioRepository;

    @Override
    public Anuncio save(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    @Override
    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public Optional<Anuncio> findById(Long id) {
        return anuncioRepository.findById(id);
    }

    @Override
    public List<Anuncio> findAllByUser(User user) {
        return anuncioRepository.findAllByUser(user);
    }
}
