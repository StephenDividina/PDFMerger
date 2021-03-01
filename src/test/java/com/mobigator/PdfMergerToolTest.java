package com.mobigator;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class PdfMergerToolTest {

    @Test
    public void assertFileFound() throws Exception {
        String[] data = new String[3];
        data[0] = "/Users/dev/Desktop/stephen.pdf";
        data[1] = "/Users/dev/Desktop/Leave.pdf";
        data[2] = "/Users/dev/Desktop/StackTrek.pdf";

        String savePdf = PdfMergeTool.mergePdf(data);

//        File file = new File(savePdf);
//        assertEquals(savePdf, file.getAbsolutePath());
//        assertTrue(file.exists());
//        file.delete();
//        assertTrue(!file.exists());
    }
}
