package com.project.app.repositories;

import com.project.app.entities.Anuncio;
import com.project.app.entities.Avaliacao;
import com.project.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao ,Long> {

    Avaliacao save(Avaliacao avaliacao);

    List<Avaliacao> findAllByAnuncio(Anuncio anuncio);

    List<Avaliacao> findAllByUser(User user);

}
