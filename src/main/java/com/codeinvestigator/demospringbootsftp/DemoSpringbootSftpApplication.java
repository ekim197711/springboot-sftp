package com.codeinvestigator.demospringbootsftp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class DemoSpringbootSftpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootSftpApplication.class, args);
    }

}
