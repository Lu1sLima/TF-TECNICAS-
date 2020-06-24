package com.project.app.persistences;

import com.project.app.entities.Anuncio;
import com.project.app.entities.Avaliacao;
import com.project.app.entities.User;
import com.project.app.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AvaliacaoRepositoryImpl implements AvaliacaoRepository {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public List<Avaliacao> findAllByAnuncio(Anuncio anuncio) {
        return avaliacaoRepository.findAllByAnuncio(anuncio);
    }

    @Override
    public List<Avaliacao> findAllByUser(User user) {
        return avaliacaoRepository.findAllByUser(user);
    }
}
