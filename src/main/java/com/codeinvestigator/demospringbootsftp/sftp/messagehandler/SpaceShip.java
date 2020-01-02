package com.codeinvestigator.demospringbootsftp.sftp.messagehandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SpaceShip {
    public String name;
    public Double fuel=15.0d;


    public SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "name='" + name + '\'' +
                ", fuel=" + fuel +
                '}';
    }
}
