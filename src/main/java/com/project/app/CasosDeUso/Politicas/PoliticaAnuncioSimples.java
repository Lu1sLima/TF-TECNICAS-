package com.project.app.CasosDeUso.Politicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Marca;

public class PoliticaAnuncioSimples implements PoliticaAnaliseAnuncio {

    public PoliticaAnuncioSimples() {

    }

    @Override
    public Anuncio maisRelevante(List<Anuncio> anuncios) {
        Anuncio maisPesquisado = anuncios.get(0);
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getVisitas() > maisPesquisado.getVisitas()) {
                maisPesquisado = anuncio;
            }
        }

        return maisPesquisado;
    }

    @Override
    public PriorityQueue<Anuncio> maisPesquisados(List<Anuncio> anuncios) {
        PriorityQueue<Anuncio> pq = new PriorityQueue<>(Collections.reverseOrder());
        anuncios.forEach(anuncio -> pq.add(anuncio));
        return pq;
    }

    @Override
    public List<Marca> analisaMarcasMaisAnunciadas(List<Anuncio> anuncios) {
        HashMap<Marca, Integer> map_dict =new HashMap<Marca,Integer>();
        List<Marca> maisAnunciadas = new ArrayList<>();

        for (Marca marca : Marca.values()){
            map_dict.put(marca, 0);
        }

        for (Anuncio anuncio : anuncios){
            map_dict.computeIfPresent(anuncio.getVehicle().getMarca(), (k, v) -> v + 1);
        }

        while(!map_dict.isEmpty()){
            Marca maior = map_dict.entrySet()
                            .stream()
                            .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                            .get()
                            .getKey();
            map_dict.remove(maior);
            maisAnunciadas.add(maior);
        }

        return maisAnunciadas;
    }

    @Override
    public Anuncio[] analisaMaisRelevantes(String cidade, List<Anuncio> anuncios) {
        PriorityQueue<Anuncio> pq_city = new PriorityQueue<Anuncio>(Collections.reverseOrder());
        Anuncio[] recomendados = new Anuncio[5];
        for (Anuncio anuncio : anuncios){
            String anuncio_cidade = anuncio.getUser().getCity();
            if(anuncio_cidade.equals(cidade)){
                pq_city.add(anuncio);
            }
        }

        if (pq_city.size() < 5){
            PriorityQueue<Anuncio> recomendados_visitas = maisPesquisados(anuncios);
            while(pq_city.size() != 5 && !recomendados_visitas.isEmpty()){
               if(!pq_city.contains(recomendados_visitas.peek())){
                    pq_city.add(recomendados_visitas.poll());
               }
               else{
                   recomendados_visitas.poll();
               }
            }
        }
        recomendados = pq_city.toArray(recomendados);
        Collections.reverse(Arrays.asList(recomendados));
        return recomendados;
    }

}