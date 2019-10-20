package com.wukj.io.path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RelativePath {

    /**
     * 获取项目根路径
     * 
     * @return
     */
    public String getRootPath() {
        return new File("").getAbsolutePath();
    }

    /**
     * 这种方法 “” 空代表的是 这个Java项目 TestSomeTechnology 由于实际项目在打包后没有src目录 所以这种方法不常用
     */
    public void getFilePath() throws IOException {
        File file = new File("resources" + File.separator + "1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String len = null;
        while ((len = br.readLine()) != null) {
            System.out.println(len);
        }
        br.close();
    }

    /**
     * 使用类的相对路径 这种方法 “/” 代表的是bin。 src文件夹和resources 文件夹下的的东西都会被加载到bin下面
     * 因为这两个文件被配置为了source
     */
    public void getClassPath() throws IOException {
        File file = new File(RelativePath.class.getResource("/1.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String len = null;
        while ((len = br.readLine()) != null) {
            System.out.println(len);
        }
        br.close();
    }


    /**
     * 这种是通过当前线程的类加载器
     * 这种方法 “ ” 空代表的是bin 。 于是就直接填写test，文件夹下的的东西都会被加载到bin下面，因为这两个文件被配置为了source
     */
    public  void  getCurrentThreadPath() throws IOException{

        File file = new File(Thread.currentThread().getContextClassLoader().getResource("1.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String len = null;
        if ((len=br.readLine())!=null){
            System.out.println(len);
        }
        br.close();
    }
}