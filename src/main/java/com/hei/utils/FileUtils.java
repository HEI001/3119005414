package com.hei.utils;

import java.io.*;

/**
 * TODO
 *
 * @author Crystry
 * @date 2021/9/14 14:05
 */
public class FileUtils {
    /**
     * 读取txt文件
     * @param filePath 读取文件路径、
     * @return 将txt文件以字符串形式返回
     */
    public static String readFile(String filePath){
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
    /**
     * 将查重得到的相似度写入txt文件中
     * @param similarity 查重率
     */
    public static void writeFile(String  similarity,String filePath){
        File file = new File(filePath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            outputStreamWriter.append("文本相似度为：");
            outputStreamWriter.append(similarity);
            //关闭写入流
            outputStreamWriter.close();
            //关闭输入流
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
