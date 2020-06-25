package com.project.app.Interfaces.RepositoriosImpl;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Avaliacao;
import com.project.app.Entidades.User;
import com.project.app.CasosDeUso.Repositorios.AvaliacaoRepository;
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
