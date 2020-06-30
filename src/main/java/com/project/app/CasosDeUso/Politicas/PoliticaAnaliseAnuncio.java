package com.project.app.CasosDeUso.Politicas;

import java.util.List;

import com.project.app.Entidades.Anuncio;

public interface PoliticaAnaliseAnuncio {
    
    Anuncio maisRelevante(List<Anuncio> anuncios);

    List<Anuncio> maisPesquisados(List<Anuncio> anuncios);
}