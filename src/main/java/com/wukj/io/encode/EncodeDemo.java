package com.wukj.io.encode;

import java.io.IOException;

public class EncodeDemo {

    public static void main(String[] args) throws IOException {

        String s = "慕课网ABC";

        // 项目默认的编码是UTF-8
        // utf-8编码方式，中文占用三个字节，英文占用一个字节
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            // 将字节转换成（int），以16进制的方式进行显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        // gbk编码方式，中文占用两个字节，英文占用一个字节
        byte[] bytes2 = s.getBytes("gbk");
        for (byte b : bytes2) {
            // 将字节转换成（int），以16进制的方式进行显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();
        // java是utf-16be编码
        byte[] bytes3 = s.getBytes("utf-16be");
        // utf-16be中文占用2个字节，英文占用2个字节
        for (byte b : bytes3) {
            // 将字节转换成（int），以16进制的方式进行显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();

        // 当字节序列使用的某种编码的情况下，想序列成字符串，也需要使用该编码方式，否则乱码
        String str  = new String(bytes3);
        System.out.println(str);
        String str2 = new String(bytes3,"utf-16be");
        System.out.println(str2);

        /**
         * 文本文件 是字节序列，可以使任意编码的字节序列
         */
        
    }

}