package com.hei.utils;

import org.junit.Test;

/**
 *
 * @author Crystry
 * @date 2021/9/1522:24
 */
public class SimHashUtilsTest {
    /**
     * 测试SimHash算法是否正常运行
     */
    @Test
    public void SimHashTest(){
        String str="今天是星期天，天气晴，今天晚上我要去看电影。";
        String s = SimHashUtils.simHash(str);
        System.out.println(s.length());
        System.out.println(s);
    }
}
