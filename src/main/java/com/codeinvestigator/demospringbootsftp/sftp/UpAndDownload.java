package com.codeinvestigator.demospringbootsftp.sftp;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

public class UpAndDownload {

    private DefaultSftpSessionFactory gimmeFactory(){
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        factory.setHost("0.0.0.0");
        factory.setPort(22);
        factory.setAllowUnknownKeys(true);
        factory.setUser("mike");
        factory.setPassword("password123");
        return factory;
    }

    public void upload(){

        SftpSession session = gimmeFactory().getSession();
        InputStream resourceAsStream =
                UpAndDownload.class.getClassLoader().getResourceAsStream("mytextfile.txt");
        try {
            session.write(resourceAsStream, "upload/mynewfile" + LocalDateTime.now() +".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.close();
    }

    public String download(){
        SftpSession session = gimmeFactory().getSession();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            session.read("upload/downloadme.txt", outputStream);
            return new String(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
