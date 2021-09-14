package com.hei.utils;

import java.io.*;

/**
 * TODO
 *
 * @author Crystry
 * @date 2021/9/1414:05
 */
public class FileUtils {
    /**
     * 读取txt文件
     * @param filePath 读取文件路径、
     * @return 将txt文件以字符串形式返回
     */
    public String readFile(String filePath){
        File file=new File(filePath);
        StringBuilder stringBuilder=new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            while (inputStreamReader.ready()){
                stringBuilder.append((char) inputStreamReader.read());
            }
            //关闭读取流
            inputStreamReader.close();
            //关闭输入流，释放资源
            fileInputStream.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }



}
