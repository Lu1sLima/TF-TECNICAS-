package com.project.app.Interfaces.Controllers;

import com.project.app.CasosDeUso.Servicos.AnuncioService;
import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnuncioController {

    @Autowired
    AnuncioService anuncioService;

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
}
