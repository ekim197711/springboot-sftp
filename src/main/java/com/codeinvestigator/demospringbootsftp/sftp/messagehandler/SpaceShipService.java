package com.codeinvestigator.demospringbootsftp.sftp.messagehandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class SpaceShipService {

    @ServiceActivator(inputChannel = "spaceship", outputChannel = "fuel")
    public SpaceShip rename(SpaceShip spaceShip){
        System.out.println(String.format("Rename SpaceShip BEGIN %s", spaceShip));
        spaceShip.name = spaceShip.name.toUpperCase();
        System.out.println("Rename SpaceShip END");
        return spaceShip;

    }

    @ServiceActivator(inputChannel = "spaceshipfuelled")
    public void renamedHappened(SpaceShip spaceShip){
        System.out.println(String.format("A Spaceship has been fuelled!!! %s", spaceShip));
    }

    @ServiceActivator(inputChannel = "fuel", outputChannel = "spaceshipfuelled")
    public SpaceShip fuel(SpaceShip spaceShip){
        System.out.println(String.format("Fuel SpaceShip BEGIN %s", spaceShip));
        spaceShip.fuel = 100.0d;
        System.out.println("Fuel SpaceShip END");
        return spaceShip;
    }
}
