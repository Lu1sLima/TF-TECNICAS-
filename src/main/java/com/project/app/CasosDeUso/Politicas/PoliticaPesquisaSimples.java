package com.project.app.CasosDeUso.Politicas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.User;

public class PoliticaPesquisaSimples implements PoliticaPesquisaAnuncio {

    @Override
    public List<Anuncio> melhorPesquisa(String cidade, List<Anuncio> anuncios) {
        List<Anuncio> anuncios_proximos = new ArrayList<>();
        for (Anuncio anuncio : anuncios){
            User usuario = anuncio.getUser();
            String cidade_anunciante = usuario.getCity();

            if (cidade == cidade_anunciante){
                anuncios_proximos.add(anuncio);
            }
        }
        return anuncios_proximos;
    }

    @Override
    public PriorityQueue<Anuncio> melhoresAvaliados(List<Anuncio> anuncios) {

        return null;
    }
    
}