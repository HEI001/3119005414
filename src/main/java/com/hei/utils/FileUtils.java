package com.hei.utils;

import com.hei.exception.EmptyTxtException;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author Crystry
 * @date 2021/9/14 14:05
 */
public class FileUtils {
    /**
     * 读取txt文件
     *
     * @param filePath 读取文件路径、
     * @return 将txt文件以字符串形式返回
     */
    public static String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            while (inputStreamReader.ready()) {
                stringBuilder.append((char) inputStreamReader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭读取流
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                //关闭输入流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (stringBuilder.length() == 0) {
                throw new EmptyTxtException("文件为空，请重新输入文件！");
            }
        } catch (EmptyTxtException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 将查重得到的相似度写入txt文件中
     *
     * @param similarity 查重率
     */
    public static void writeFile(String similarity, String filePath) {
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            outputStreamWriter.append("文本相似度为：");
            outputStreamWriter.append(similarity);
            //关闭写入流
            outputStreamWriter.close();
            //关闭输入流
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
