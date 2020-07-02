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
        List<Anuncio> anunciosToReturn = new ArrayList<>();

        for (Anuncio anuncio : anuncios){
            List<String> matchables = new ArrayList<>();
            matchables.add(anuncio.getTitle().toLowerCase());
            matchables.add(anuncio.getDescription().toLowerCase());
            matchables.add(anuncio.getVehicle().getModelo());
            matchables.add(anuncio.getVehicle().getTipo().toString().toLowerCase());
            matchables.add(anuncio.getVehicle().getMarca().toString().toLowerCase());
            if(anuncio.getVehicle().getNovo() != null && anuncio.getVehicle().getNovo()){
                matchables.add("Novo".toLowerCase());
                matchables.add("Zero".toLowerCase());
            }else{
                matchables.add("Usado".toLowerCase());
            }
            matchables.add(anuncio.getUser().getName().toLowerCase());
            matchables.add(anuncio.getUser().getEmail().toLowerCase());
            matchables.add(anuncio.getUser().getContact().toLowerCase());
            matchables.add(anuncio.getUser().getCity().toLowerCase());
            if(matchables.contains(keyword.toLowerCase())){
                anunciosToReturn.add(anuncio);
            }
        }
        return anunciosToReturn;
    }

    @Override
    public PriorityQueue<Anuncio> melhoresAvaliados(List<Anuncio> anuncios) {

        return null;
    }
    
}