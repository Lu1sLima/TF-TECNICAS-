package com.project.app.CasosDeUso.Politicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.project.app.Entidades.Anuncio;

public class PoliticaAnuncioSimples implements PoliticaAnaliseAnuncio {


    public PoliticaAnuncioSimples(){

    }
    @Override
    public Anuncio maisRelevante(List<Anuncio> anuncios) {
        Anuncio maisPesquisado = anuncios.get(0);
        for(Anuncio anuncio : anuncios){
            if (anuncio.getVisitas() > maisPesquisado.getVisitas()){
                maisPesquisado = anuncio;
            }
        }

        return maisPesquisado;
    }

    @Override
    public List<Anuncio> maisPesquisados(List<Anuncio> anuncios) {
        PriorityQueue <Anuncio> pq = new PriorityQueue<>(Collections.reverseOrder());
        anuncios.forEach(anuncio -> pq.add(anuncio));
        return new ArrayList<Anuncio>(pq);
    }
    
    
}