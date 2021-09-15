package com.hei;

import static org.junit.Assert.assertTrue;

import com.hei.utils.FileUtils;
import com.hei.utils.HammingUtils;
import com.hei.utils.SimHashUtils;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void MainTest() {
        String orig = "D:\\java\\Learn\\Homework\\text\\orig.txt";
        String filePath = "D:\\java\\Learn\\Homework\\text\\similarity.txt";
        String[] origs = {
                "D:\\java\\Learn\\Homework\\text\\orig_0.8_add.txt",
                "D:\\java\\Learn\\Homework\\text\\orig_0.8_del.txt",
                "D:\\java\\Learn\\Homework\\text\\orig_0.8_dis_1.txt",
                "D:\\java\\Learn\\Homework\\text\\orig_0.8_dis_10.txt"
        };
        for (String s : origs) {
            String similarity = HammingUtils.getSimilarity(SimHashUtils.simHash(FileUtils.readFile(orig)),
                    SimHashUtils.simHash(FileUtils.readFile(s)));
            System.out.println(similarity);
            FileUtils.writeFile(similarity, filePath);
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
