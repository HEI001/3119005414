package com.hei.utils;

import org.junit.Test;

/**
 *
 * @author Crystry
 * @date 2021/9/1415:24
 */
public class HammingUtilsTest {
    /**
     * 测试海明距离算法代码是否正常运行
     */
    @Test
    public void getSimilarity(){
        String file1 = FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\orig.txt");
        String file2 = FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\orig_0.8_add.txt");
        String s = SimHashUtils.simHash(file1);
        String s1 = SimHashUtils.simHash(file2);
        System.out.println(HammingUtils.getSimilarity(s,s1));
    }

    /**
     * 测试获取文件的simHash值
     */
    @Test
    public void simHashTest(){
        String file1 = FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\orig.txt");
        System.out.println( SimHashUtils.simHash(file1));
    }
}
