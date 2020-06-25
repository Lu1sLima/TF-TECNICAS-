package com.project.app.CasosDeUso.Repositorios;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Avaliacao;
import com.project.app.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao ,Long> {

    Avaliacao save(Avaliacao avaliacao);

    List<Avaliacao> findAllByAnuncio(Anuncio anuncio);

    List<Avaliacao> findAllByUser(User user);

}
