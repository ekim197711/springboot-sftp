package com.codeinvestigator.demospringbootsftp.sftp;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

public class SftpSessionFactoryHandler {

    public DefaultSftpSessionFactory gimmeFactory(){
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        factory.setHost("0.0.0.0");
        factory.setPort(22);
        factory.setAllowUnknownKeys(true);
        factory.setUser("mike");
        factory.setPassword("password123");
        return factory;
    }
}
