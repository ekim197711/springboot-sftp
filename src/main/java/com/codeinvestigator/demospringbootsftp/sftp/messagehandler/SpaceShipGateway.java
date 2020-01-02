package com.codeinvestigator.demospringbootsftp.sftp.messagehandler;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface SpaceShipGateway {

    @Gateway(requestChannel = "spaceship")
    public void spaceshipCreated(SpaceShip spaceShip);
}
