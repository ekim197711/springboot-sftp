package com.codeinvestigator.demospringbootsftp.sftp.safe;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpAndDownloadSafeTest {



    @Test
    public void uploadSafe() {
        new UpAndDownloadSafe().uploadSafe();
    }

    @Test
    public void downloadSafe() {
    }
}