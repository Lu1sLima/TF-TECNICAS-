package com.project.app.Interfaces.Controllers;

import com.project.app.CasosDeUso.Politicas.PoliticaAnaliseAnuncio;
import com.project.app.CasosDeUso.Politicas.PoliticaAnuncioSimples;
import com.project.app.CasosDeUso.Servicos.AnuncioService;
import com.project.app.CasosDeUso.Servicos.AvaliacaoService;
import com.project.app.CasosDeUso.Servicos.UserService;
import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Avaliacao;
import com.project.app.Entidades.Marca;
import com.project.app.Entidades.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnuncioController {

    @Autowired
    AnuncioService anuncioService;

    @Autowired
    AvaliacaoService avaliacaoService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/anuncio/findAll")
    public List<Anuncio> findAllAnuncios() {
        return anuncioService.findAll();
    }

    @GetMapping(value = "/anuncio/{id}")
    public Anuncio findById(@PathVariable Long id){
        return anuncioService.findById(id).get();
    }

    @GetMapping(value = "/marcas")
    public Marca[] findAllMarcas(){
        return Marca.values();
    }

    @GetMapping(value = "/anuncio/avaliacoes/{id}")
    public List<Avaliacao> findAllAvaliacoesByIdOfAnuncio(@PathVariable Long id){
        Anuncio anuncio = anuncioService.findById(id).get();
        return avaliacaoService.findAllByAnuncio(anuncio);
    }

    @PostMapping(value = "/anuncio/avaliacoes/{anuncioId}/{userId}/{comentario}/{pontuacao}")
    public Avaliacao createAvaliacao(@PathVariable long anuncioId, @PathVariable long userId,
                                     @PathVariable String comentario,@PathVariable int pontuacao
                                     ){
        Anuncio anuncio = anuncioService.findById(anuncioId).get();
        User user = userService.findById(userId);
        Avaliacao avaliacao = new Avaliacao(anuncio,user,comentario,pontuacao);
        return avaliacaoService.addAvaliacao(avaliacao);
    }

    @GetMapping(value = "/anuncio/relevantes/{city}")
    public Anuncio[] findAllAnunciosRelevantes(@PathVariable String city){
        PoliticaAnaliseAnuncio politica = new PoliticaAnuncioSimples();
        return politica.analisaMaisRelevantes(city, anuncioService.findAll());
    }

}
