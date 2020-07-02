package com.project.app;

import java.util.ArrayList;
import java.util.List;

import com.project.app.CasosDeUso.Politicas.PoliticaPesquisaAnuncio;
import com.project.app.CasosDeUso.Politicas.PoliticaPesquisaSimples;
import com.project.app.Entidades.Anuncio;
import com.project.app.Entidades.Marca;
import com.project.app.Entidades.Tipo;
import com.project.app.Entidades.User;
import com.project.app.Entidades.Vehicle;
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
    PoliticaPesquisaAnuncio politicaPesquisa = new PoliticaPesquisaSimples();
    Anuncio mostRelevant;
    Anuncio secondMostRelevant;

    @Before
    public void initialize(){
        User user = new User("test","test@test.com","test","5132433233","POA");
        User user2 = new User("Luis Lima","tes2t@test.com","test2","51323232433233","VIAMAO");
        User user3 = new User("Adilson Medronha","tes2t@test.com","test2","51323232433233","VIAMAO");
        User user4 = new User("Lucas Garcia","tes2t@test.com","test2","51323232433233","VIAMAO");
        
        Vehicle vehicle1 = new Vehicle.Builder()
                          .placa("198345")
                          .modelo("fusca")
                          .marca(Marca.Volkswagen)
                          .tipo(Tipo.Hatch)
                          .build();   

        Vehicle vehicle2 = new Vehicle.Builder()
                          .placa("10945")
                          .modelo("Peugeot 308")
                          .marca(Marca.Chevrolet)
                          .tipo(Tipo.Hatch)
                          .build();

        Vehicle vehicle3 = new Vehicle.Builder()
                          .placa("125")
                          .modelo("Celta")
                          .marca(Marca.Chevrolet)
                          .tipo(Tipo.Hatch)
                          .build();

        mostRelevant = new Anuncio(user, "relevant", "testRelevant", vehicle3, 2300D);
        this.mostRelevant.setVisitas(20);
        anuncios.add(mostRelevant);
        Anuncio n1 = new Anuncio(user2, "teste anuncio", "teste description", vehicle3, 2500D);
        n1.setVisitas(3);
        this.anuncios.add(n1);
        secondMostRelevant = new Anuncio(user3, "second most relevant", "teste description", vehicle2, 2300D);
        this.secondMostRelevant.setVisitas(10);
        this.anuncios.add(secondMostRelevant);
        Anuncio n3 = new Anuncio(user4, "teste anuncio3", "teste description", vehicle3, 20000D);
        n3.setVisitas(4);
        this.anuncios.add(n3);
        Anuncio n4 = new Anuncio(user3, "teste anuncio6", "teste description", vehicle2, 2300D);
        n4.setVisitas(1);
        this.anuncios.add(n4);
    }

    @Test
    public void shouldGetMostRelevant(){

        Anuncio maisRelevante = this.politica.maisRelevante(this.anuncios);
        Assert.assertEquals(maisRelevante, this.mostRelevant);
    }

    @Test
    public void shouldGetMarcasMaisAnunciadas(){
        List<Marca> maisAnunciadas = this.politica.analisaMarcasMaisAnunciadas(this.anuncios);

        Assert.assertEquals(Marca.Chevrolet, maisAnunciadas.get(0));
        
    }

    @Test
    public void shouldAnalyseMostRelevant(){
        String cidade = "POA";

        Anuncio[] recomendados = this.politica.analisaMaisRelevantes(cidade, this.anuncios);

        Assert.assertEquals(recomendados[0].getUser().getCity(), mostRelevant.getUser().getCity());
        Assert.assertEquals(recomendados[4].getVisitas(),  secondMostRelevant.getVisitas());
    }

    @Test
    public void shouldReturnMatchableAnuncio(){
        String keyword = "viamao";

        List<Anuncio> anunciosRetornados = politicaPesquisa.melhorPesquisa(keyword,this.anuncios);
        Assert.assertTrue(anunciosRetornados.size() > 0);


    }


}