package com.hei.utils;

import org.junit.Test;

/**
 * TODO
 *
 * @author Crystry
 * @date 2021/9/1415:24
 */
public class HammingUtilsTest {
    @Test
    public void getSimilarity(){
        String file1 = FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\orig.txt");
        String file2 = FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\orig_0.8_add.txt");
        String s = SimHashUtils.simHash(file1);
        String s1 = SimHashUtils.simHash(file2);
        System.out.println(HammingUtils.getSimilarity(s,s1));
    }
}
