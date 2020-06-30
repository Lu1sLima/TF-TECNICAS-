package com.project.app;

import java.util.ArrayList;
import java.util.List;

import com.project.app.Entidades.Anuncio;
import com.project.app.CasosDeUso.Politicas.PoliticaAnaliseAnuncio;
import com.project.app.CasosDeUso.Politicas.PoliticaAnuncioSimples;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.BeforeEach;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoliticaAnuncioTest {
    List<Anuncio> anuncios = new ArrayList<>();;
    PoliticaAnaliseAnuncio politica = new PoliticaAnuncioSimples();
    Anuncio mostRelevant = new Anuncio(null, "relevant", "testRelevant", null, 2000D);

    @Before
    public void initialize(){

        this.mostRelevant.setVisitas(20);
        anuncios.add(mostRelevant);
        Anuncio n1 = new Anuncio(null, "teste anuncio", "teste description", null, 2500D);
        n1.setVisitas(3);
        this.anuncios.add(n1);
        Anuncio n2 = new Anuncio(null, "teste anuncio2", "teste description", null, 2300D);
        n2.setVisitas(10);
        this.anuncios.add(n2);
        Anuncio n3 = new Anuncio(null, "teste anuncio3", "teste description", null, 20000D);
        n3.setVisitas(4);
        this.anuncios.add(n3);
    }

    @Test
    public void shouldGetMostRelevant(){

        Anuncio maisRelevante = this.politica.maisRelevante(this.anuncios);
        Assert.assertEquals(maisRelevante, this.mostRelevant);
    }
}