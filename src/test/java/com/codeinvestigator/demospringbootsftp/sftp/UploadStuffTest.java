package com.codeinvestigator.demospringbootsftp.sftp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UploadStuffTest {

    @Test
    public void upload() {
        new UpAndDownload().upload();
    }

    @Test
    public void download() {
        String download = new UpAndDownload().download();
        System.out.println("Downloaded text\n" + download);
    }
}