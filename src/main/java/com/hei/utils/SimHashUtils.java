package com.hei.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.StringTokenizer;

/**
 *
 * @author Crystry
 * @date 2021/9/14 14:05
 */
public class SimHashUtils {
    private static final int HASH_BITS = 64;

    /**
     * 传入String，计算出它的hash值，并以字符串形式输出
     * @param tokens 传入的String类型字符串
     * @return 返回tokens的hash值
     */
    public static String simHash(String tokens) {
        // 定义特征向量/数组
        int[] v = new int[HASH_BITS];
        //1、分词，将文本去掉格式,将" \t\n\r\f"为分隔符，进行分词
        StringTokenizer stringTokens = new StringTokenizer(tokens);
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            //2、hash，得到每个分词hash，将每一个分词hash为一组固定长度的数列。
            BigInteger t = hash(temp);
            for (int i = 0; i < HASH_BITS; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                // 3、加权，W = Hash * weight，逢1加1,逢0减1.直到把所有的分词hash数列全部判断完毕
                int weight=1;   //权重值为1
                if (t.and(bitmask).signum() != 0) {
                    //4、合并，计算文档特征向量和
                    v[i] += weight;
                } else {
                    v[i] -= weight;
                }
            }
        }
        StringBuilder simHashBuilder = new StringBuilder();
        for (int i = 0; i < HASH_BITS; i++) {
            // 5、降维，最后对数组进行判断,大于0的记为1,小于等于0的记为0,得到语句的 simhash 值
            if (v[i] >= 0) {
                simHashBuilder.append("1");
            }else{
                simHashBuilder.append("0");
            }
        }
        return simHashBuilder.toString();
    }

    /**
     *传入str，计算出它的hash值，并以二进制形式返回
     * @param str 传入字符串
     * @return 得到的二进制转回BigInteger类型返回
     */
    public static BigInteger hash(String str) {
        try{
            // 这里使用了MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String s = new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
            return  new BigInteger(s);
        }catch(Exception e){
            e.printStackTrace();
            return new BigInteger(str);
        }
    }
}
