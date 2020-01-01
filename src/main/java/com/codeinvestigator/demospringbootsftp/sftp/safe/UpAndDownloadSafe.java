package com.codeinvestigator.demospringbootsftp.sftp.safe;

import com.codeinvestigator.demospringbootsftp.sftp.SftpSessionFactoryHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
@Slf4j
public class UpAndDownloadSafe {



    public void uploadSafe(){
        SftpSession session = new SftpSessionFactoryHandler().gimmeFactory().getSession();
        InputStream resourceAsStream =
                UpAndDownloadSafe.class.getClassLoader().getResourceAsStream("mytextfile.txt");
        try {
            String filename = String.format("mynewfile%s.txt", LocalDateTime.now());
            String destination = String.format("upload/beinguploaded/%s", filename);
            log.info("Write file to: " + destination);

            session.write(resourceAsStream, destination);
            String donedestination = String.format("upload/done/%s", filename);
            log.info("Rename file to: " + donedestination);
            session.rename(destination, donedestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.close();
    }

    public String downloadSafe(){
        SftpSession session = new SftpSessionFactoryHandler().gimmeFactory().getSession();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            session.read("upload/downloadme.txt", outputStream);
            return new String(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
