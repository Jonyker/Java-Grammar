package com.wukj.tools.compress;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompressTodo {
    public static void main(String []args) throws Exception {

        String filePath = "/Users/wukj/Desktop/bytefile";
        System.out.print("\nobj-------------\n");
        DataInputStream dis = null;
        try {
            /*创建二进制输入流*/
            dis = new DataInputStream(new FileInputStream(filePath));
            
            /*循环读取并输出信息*/
            int temp;
            while((temp=dis.read())!=-1){
                System.out.print((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if (dis!=null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print("\nobj-------------\n");
    }

}
