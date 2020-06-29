package com.project.app;

import com.project.app.CasosDeUso.Repositorios.UserRepository;
import com.project.app.Entidades.*;
import com.project.app.CasosDeUso.Servicos.AnuncioService;
import com.project.app.CasosDeUso.Servicos.UserService;
import com.project.app.CasosDeUso.Servicos.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncioTest {

    @Autowired
    UserService userService;

    @Autowired
    AnuncioService anuncioService;


    @Test
    public void shouldCreateAnuncio() {
        User user = new User("Tester","email@email","passwordTest","4342423","POA");

        Vehicle vehicle = new Vehicle.Builder()
                .placa("123457")
                .modelo("fusca")
                .marca(Marca.Chevrolet)
                .tipo(Tipo.Hatch)
                .build();



        Anuncio anuncio = new Anuncio(user, "teste anuncio", "teste description", vehicle, 2500D);

        anuncio.setDescription("teste description2");

        Assert.assertEquals("Tester",anuncio.getUser().getName());
        Assert.assertEquals("teste anuncio",anuncio.getTitle());
        Assert.assertEquals("teste description2", anuncio.getDescription());
        Assert.assertEquals("fusca", anuncio.getVehicle().getModelo());
    }

    @Test
    public void shouldGetAllAnunciosByUser(){
        List<Anuncio> anunciosByUser = new ArrayList<>();
        User user1 = userService.findById(1L);
        anunciosByUser = anuncioService.findAllByUser(user1);
        Assert.assertTrue(anunciosByUser.size() > 1);


    }

//    @Test
//    public void shouldGetAllAnunciosByUser() {
//        Vehicle vehicle = new Vehicle.Builder()
//                .placa("1234578")
//                .modelo("fusca")
//                .marca(Marca.Chevrolet)
//                .tipo(Tipo.Hatch)
//                .preco(25000D)
//                .build();
//
//        vehicleService.addVehicle(vehicle);
//
//        Anuncio anuncio = anuncioService.addAnuncio(
//                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
//                        "teste description", vehicleService.findVehicleByPlaca("1234578"))
//        );
//
//        Anuncio anuncio2 = anuncioService.addAnuncio(
//                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
//                        "teste description", vehicleService.findVehicleByPlaca("123"))
//        );
//
//
//        Assert.assertTrue(anuncioService.findAllByUser(userService.findUserByEmail("admin@admin.com")).size() >= 2);
//    }
}