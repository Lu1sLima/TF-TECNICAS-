package com.project.app.CasosDeUso.Servicos;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.User;
import com.project.app.CasosDeUso.Repositorios.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    @Autowired
    AnuncioRepository anuncioRepository;


    public Anuncio addAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }


    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    public Optional<Anuncio> findById(Long id) { return anuncioRepository.findById(id);}

    public List<Anuncio> findAllByUser(User user ){ return  anuncioRepository.findAllByUser(user);}


}
