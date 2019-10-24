package com.wukj.io.bytes;

import java.io.IOException;

import org.junit.Test;

public class ByteOptionTest {

    @Test
    public void testReadByteFile() throws IOException {
        new ByteOption().readByteFile();
    }


    @Test
    public void testReadBufferWriteToByteFile() throws IOException {
        new ByteOption().readBufferByteFile();
    }
}