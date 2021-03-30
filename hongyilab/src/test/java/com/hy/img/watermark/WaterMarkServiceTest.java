package com.hy.img.watermark;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-02-01
 *  \* Time: 11:54
 *  \* Description: 
 *  \
 */
public class WaterMarkServiceTest {
    private WaterMark waterMarkService;

    @Before
    public void init() {
        waterMarkService = new WaterMark.Builder().rotateAngle(30).gapWidth(200).gapHeight(200).build();
    }

    @Test
    public void testTextWaterMark() throws Exception {
        String textStr = "12345测试12345";
        String inPath = Paths.get("src", "test/resources/test1.png").toAbsolutePath().toString();
        String outPath = Paths.get("src", "test/resources/test1_wm.png").toAbsolutePath().toString();

        waterMarkService.textWaterMark(new FileInputStream(inPath), new FileOutputStream(outPath), textStr, 600, 700);
    }

    @Test
    public void testMoreTextWaterMark() throws Exception {
        String textStr = "12345测试12345";
        String inPath = Paths.get("src", "test/resources/test1.png").toAbsolutePath().toString();
        String outPath = Paths.get("src", "test/resources/test1_mwm.png").toAbsolutePath().toString();

        waterMarkService.moreTextWaterMark(new FileInputStream(inPath), new FileOutputStream(outPath), textStr);
    }

}
