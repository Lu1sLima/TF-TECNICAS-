package com.project.app;

import com.project.app.entities.Anuncio;
import com.project.app.entities.Marca;
import com.project.app.entities.Tipo;
import com.project.app.entities.Vehicle;
import com.project.app.services.AnuncioService;
import com.project.app.services.UserService;
import com.project.app.services.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncioTest {

    @Autowired
    AnuncioService anuncioService;

    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;

    @Test
    public void shouldAddAnuncio() {
        Vehicle vehicle = new Vehicle.Builder()
                .placa("123457")
                .modelo("fusca")
                .marca(Marca.Chevrolet)
                .tipo(Tipo.Hatch)
                .preco(25000D)
                .build();

        vehicleService.addVehicle(vehicle);

        Anuncio anuncio = anuncioService.addAnuncio(
                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
                        "teste description", vehicleService.findVehicleByPlaca("123457"))
        );
        Assert.assertEquals("teste anuncio", anuncioService.findById(anuncio.getId()).get().getTitle());

        Assert.assertEquals("123457", anuncioService.findById(anuncio.getId()).get().getVehicle().getPlaca());

    }

    @Test
    public void shouldGetAllAnunciosByUser() {
        Vehicle vehicle = new Vehicle.Builder()
                .placa("1234578")
                .modelo("fusca")
                .marca(Marca.Chevrolet)
                .tipo(Tipo.Hatch)
                .preco(25000D)
                .build();

        vehicleService.addVehicle(vehicle);

        Anuncio anuncio = anuncioService.addAnuncio(
                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
                        "teste description", vehicleService.findVehicleByPlaca("1234578"))
        );

        Anuncio anuncio2 = anuncioService.addAnuncio(
                new Anuncio(userService.findUserByEmail("admin@admin.com"), "teste anuncio",
                        "teste description", vehicleService.findVehicleByPlaca("123"))
        );


        Assert.assertTrue(anuncioService.findAllByUser(userService.findUserByEmail("admin@admin.com")).size() >= 2);
    }
}