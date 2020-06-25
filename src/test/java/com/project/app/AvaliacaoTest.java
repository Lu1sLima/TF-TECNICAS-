package com.project.app;

import com.project.app.Entidades.*;
import com.project.app.CasosDeUso.Servicos.AnuncioService;
import com.project.app.CasosDeUso.Servicos.AvaliacaoService;
import com.project.app.CasosDeUso.Servicos.UserService;
import com.project.app.CasosDeUso.Servicos.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvaliacaoTest {

    @Autowired
    AvaliacaoService avaliacaoService;

    @Autowired
    AnuncioService anuncioService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    Anuncio anuncio;



    @Test
    public void shouldAddAvaliacao(){
        Vehicle vehicle = new Vehicle.Builder()
                .placa("12345784")
                .modelo("fusca")
                .marca(Marca.Chevrolet)
                .tipo(Tipo.Hatch)
                .preco(25000D)
                .build();

        vehicleService.addVehicle(vehicle);

        anuncio = anuncioService.addAnuncio(
                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
                        "teste description", vehicleService.findVehicleByPlaca("1234578"))
        );

        Avaliacao avaliacao = avaliacaoService.addAvaliacao(new Avaliacao(anuncioService.findAllByUser
                (userService.findUserByEmail("admin@admin.com")).get(0),
                userService.findUserByEmail("admin@admin.com"),"muito bom", 5));


        Assert.assertEquals("muito bom",avaliacaoService.findAllByAnuncio(anuncio).get(0).getComentario());
    }

}
