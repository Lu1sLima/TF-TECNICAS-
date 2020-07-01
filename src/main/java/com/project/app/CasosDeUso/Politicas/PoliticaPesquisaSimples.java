package com.project.app.CasosDeUso.Politicas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.User;

public class PoliticaPesquisaSimples implements PoliticaPesquisaAnuncio {

    @Override
    public List<Anuncio> melhorPesquisa(String keyword, List<Anuncio> anuncios) {
        
        for (Anuncio anuncio : anuncios){
            List<String> matchables = new ArrayList<>();
            
        }
        return anuncios_proximos;
    }

    @Override
    public PriorityQueue<Anuncio> melhoresAvaliados(List<Anuncio> anuncios) {

        return null;
    }
    
}