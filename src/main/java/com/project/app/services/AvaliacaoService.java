package com.project.app.services;

import com.project.app.entities.Anuncio;
import com.project.app.entities.Avaliacao;
import com.project.app.entities.User;
import com.project.app.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Transactional
    public Avaliacao addAvaliacao(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> findAllByAnuncio(Anuncio anuncio){
        return avaliacaoRepository.findAllByAnuncio(anuncio);
    };

    public List<Avaliacao> findAllByUser(User user){
        return avaliacaoRepository.findAllByUser(user);
    };


}
