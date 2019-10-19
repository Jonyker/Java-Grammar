package com.wukj.tools.character;

import java.io.*;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/24 0024 下午 2:40
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/24 0024 下午 2:40
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class FormatChar {

    public static void main(String[] args) {

        // System.out.println("args：" + args.length);

        String inPath = "d:/data.txt";
        String outPath = "d:/out.txt";
        String charset = "UTF-8";
        String separator = ",";
        int sepIndex = 2;
        try {

            FileOutputStream fis = new FileOutputStream(outPath);
            OutputStreamWriter osw = new OutputStreamWriter(fis,charset);
            BufferedWriter bw = new BufferedWriter(osw);

            FileInputStream input = new FileInputStream(inPath);
            InputStreamReader iReader = new InputStreamReader(input, charset);
            BufferedReader reader = new BufferedReader(iReader);
            StringBuffer buffer = new StringBuffer();
            char[] chs = new char[1024];
            while (-1 != reader.read(chs)) {
                buffer.append(chs);
            }
            String[] numbers = buffer.toString().split(separator);
            int length = numbers.length;
            for (int i=0;i<length;i++ ) {
                bw.write(numbers[i]);
                if (i%sepIndex == 0){
                    bw.newLine();
                }
            }
            reader.close();
            bw.flush();
            bw.close();
            osw.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }


}
