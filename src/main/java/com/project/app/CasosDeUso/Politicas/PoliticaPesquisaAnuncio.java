package com.project.app.CasosDeUso.Politicas;

import java.util.List;
import java.util.PriorityQueue;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Marca;

public interface PoliticaPesquisaAnuncio {

    List<Anuncio> melhorPesquisa(String keyword, List<Anuncio> anuncios);
    PriorityQueue<Anuncio> melhoresAvaliados(List<Anuncio> anuncios);
}