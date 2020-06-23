package com.project.app;

import com.project.app.entities.Marca;
import com.project.app.entities.Tipo;
import com.project.app.entities.Vehicle;
import com.project.app.services.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleTest {

    @Autowired
    VehicleService vehicleService;

    @Test
    public void ShouldAddVehicle(){
        Vehicle vehicle = new Vehicle.Builder()
                .placa("12345")
                .modelo("fusca")
                .marca(Marca.Chevrolet)
                .tipo(Tipo.Hatch)
                .preco(25000D)
                .build();
        System.out.println(vehicle);
        vehicleService.addVehicle(vehicle);
        Vehicle expected = vehicleService.findVehicleByPlaca("12345");
        Assert.assertEquals("fusca",expected.getModelo());
    }

    @Test
    public void ShouldFindVehicleByPlaca(){
        Vehicle expected = vehicleService.findVehicleByPlaca("123");
         Assert.assertEquals("fiesta", expected.getModelo());
    }

}
