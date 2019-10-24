package com.wukj.io.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ByteOption {

    /**
     * 【读取文本文件内容】
     * 
     * @throws IOException
     */
    public void readByteFile() throws IOException {
        FileInputStream in = new FileInputStream("resources/1.txt");
        // 默认使用项目中使用的utf-8的编码方式读取，需要手动设置成文件文件自身的编码方式
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        // 表示InputStreamReader读取单个字符到int里面
        int c;
        while ((c = isr.read()) != -1) {
            // 将int中的字符数据转化成char表示出来
            System.out.print((char) c);
        }
        isr.close();
    }

    /**
     * 【批量读取】文本文件内容
     * 
     * @throws IOException
     */
    public void readBufferByteFile() throws IOException {
        FileInputStream in = new FileInputStream("resources/1.txt");
        InputStreamReader isr = new InputStreamReader(in);

        FileOutputStream out = new FileOutputStream("resources/2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out);
        // 读取字节的长度
        int c;
        char[] buffer = new char[8 * 1024];
        // 将文本文件中的数据读取到buffer中
        while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
            String str = new String(buffer, 0, c);
            System.out.print(str);
            osw.write(buffer, 0, c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }

}