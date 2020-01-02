package com.codeinvestigator.demospringbootsftp.sftp.messagehandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceShipRestController {
    private final SpaceShipGateway gateway;

    @Autowired
    public SpaceShipRestController(SpaceShipGateway gateway) {
        this.gateway = gateway;
    }

    @GetMapping("/api/spaceship/{name}")
    public SpaceShip newSpaceShip(@PathVariable String name){
        System.out.println("new Spaceship rest BEGIN");
        SpaceShip spaceShip = new SpaceShip(name);
        gateway.spaceshipCreated(spaceShip);
        System.out.println("new Spaceship rest END");
        return spaceShip;
    }
}
