package com.hei.exception;

import com.hei.utils.FileUtils;
import org.junit.Test;

/**
 *
 * @author Crystry
 * @date 2021/9/16 20:45
 */
public class EmptyTxtExceptionTest {
    @Test
    public void testException(){
        //这是一个空文本文件
         FileUtils.readFile("D:\\java\\Learn\\Homework\\text\\empty.txt");
    }
}
