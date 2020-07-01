package com.project.app.CasosDeUso.Politicas;

import java.util.List;
import java.util.PriorityQueue;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Marca;

public interface PoliticaAnaliseAnuncio {
    
    Anuncio maisRelevante(List<Anuncio> anuncios);
    PriorityQueue<Anuncio> maisPesquisados(List<Anuncio> anuncios);
    List<Marca> analisaMarcasMaisAnunciadas(List<Anuncio> anuncios);
    Anuncio[] analisaMaisRelevantes(String cidade, List<Anuncio> anuncios);
}