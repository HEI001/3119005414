package com.hei;

import com.hei.utils.FileUtils;
import com.hei.utils.HammingUtils;
import com.hei.utils.SimHashUtils;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        //从命令行中读取原文文件、抄袭文件
        String orig= FileUtils.readFile(args[0]);
        String plagiarize=FileUtils.readFile(args[1]);
        //由字符串得到SimHash值，然后计算海明距离，得到相似度
        String similarity = HammingUtils.getSimilarity(SimHashUtils.simHash(orig), SimHashUtils.simHash(plagiarize));
        //将相似度输出到答案文件中
        FileUtils.writeFile(similarity,args[2]);
        System.exit(0);
    }
}
