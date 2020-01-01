package com.codeinvestigator.demospringbootsftp.sftp.batch;

import com.codeinvestigator.demospringbootsftp.sftp.SftpSessionFactoryHandler;
import com.sun.xml.messaging.saaj.util.ByteInputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.sftp.session.SftpSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@Slf4j
public class UploadMultipleFiles {

    public static final String DONE_FOLDER = "upload/done_batch/";
    private static final String INPROGRESS_FOLDER = "upload/beinguploaded/";

    public void uploadMultipleFiles(){
        SftpSession session = new SftpSessionFactoryHandler().gimmeFactory().getSession();
        for (int i = 0; i < 100; i++) {
            String content = String.format("This is a test! Trlalala. Test no: %s", i);
            String filename = String.format("fileno%s",i);
            upload(content, filename, session);
        }
        session.close();
    }

    private void upload(String content, String originalFilename, SftpSession session){

        String filename = String.format("%s_%s.txt", originalFilename,  LocalDateTime.now());
        String destination = String.format("%s%s", INPROGRESS_FOLDER, filename);
        String donedestination = String.format("%s%s",DONE_FOLDER, filename);

        try {
            log.info("Write file to: " + destination);
            ByteInputStream byteInputStream = new ByteInputStream(content.getBytes(), content.getBytes().length);
            session.write(byteInputStream, destination);

            log.info("Rename file to: " + donedestination);
            session.rename(destination, donedestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
