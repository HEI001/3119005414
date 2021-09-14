package com.hei.utils;

/**
 *
 * @author Crystry
 * @date 2021/9/1415:17
 */
public class HammingUtils {
    /**
     * 计算来两个字符串的海明距离,海明距离越小，说明越相似;
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 将距离返回
     */
    public static double getDistance(String str1, String str2) {
        double distance;
        if (str1.length() != str2.length()) {
            distance = -1;
        } else {
            distance = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    /**
     * 输入两个simHash值，计算输出相似度
     * @param simHash1
     * @param simHash2
     * @return 相似度
     */
    public static String getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        double distance = getDistance(simHash1, simHash2);
        // 通过海明距离计算出相似度，并返回
        return  String.format("%.2f", (100 - distance * 100 / 128)) + "%";

    }
}
