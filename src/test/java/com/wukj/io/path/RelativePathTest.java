package com.wukj.io.path;

import java.io.IOException;

import org.junit.Test;

public class RelativePathTest {

    @Test
    public void testGetRootPath() {
        System.out.println(new RelativePath().getRootPath());
    }

    @Test
    public void testGetFilePath() throws IOException {
        new RelativePath().getFilePath();
    }

    @Test
    public void testGetClassPath() throws IOException {
        new RelativePath().getClassPath();
    }

    @Test
    public void testGetCurrentThreadPath() throws IOException {
        new RelativePath().getCurrentThreadPath();
    }

}
