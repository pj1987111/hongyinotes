package com.hy.img.watermark;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-02-01
 *  \* Time: 11:37
 *  \* Description: 
 *  \
 */
public class WaterMark {
    /**
     * 水印文字字体
     */
    private final String fontName;
    /**
     * 水印文字样式
     */
    private final int fontStyle;
    /**
     * 水印文字大小
     */
    private final int fontSize;
    /**
     * 水印文字颜色
     */
    private final Color fontColor;
    /**
     * 水印透明度
     */
    private final float alpha;
    /**
     * 水印旋转角度
     */
    private final int rotateAngle;
    /**
     * 多水印间隔宽度
     */
    private final int gapWidth;
    /**
     * 多水印间隔高度
     */
    private final int gapHeight;

    private WaterMark(Builder builder) {
        this.fontName = builder.fontName;
        this.fontStyle = builder.fontStyle;
        this.fontSize = builder.fontSize;
        this.fontColor = builder.fontColor;
        this.alpha = builder.alpha;
        this.rotateAngle = builder.rotateAngle;
        this.gapWidth = builder.gapWidth;
        this.gapHeight = builder.gapHeight;
    }

    public static class Builder {
        private String fontName = "微软雅黑";
        private int fontStyle = Font.BOLD;
        private int fontSize = 40;
        private Color fontColor = Color.white;
        private float alpha = 0.3F;
        private int rotateAngle = 0;
        private int gapWidth = 200;
        private int gapHeight = 200;

        public Builder fontName(String fontName) {
            this.fontName = fontName;
            return this;
        }

        public Builder fontStyle(Integer fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        public Builder fontSize(Integer fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public Builder fontColor(Color fontColor) {
            this.fontColor = fontColor;
            return this;
        }

        public Builder alpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder rotateAngle(int rotateAngle) {
            this.rotateAngle = rotateAngle;
            return this;
        }

        public Builder gapWidth(int gapWidth) {
            this.gapWidth = gapWidth;
            return this;
        }

        public Builder gapHeight(int gapHeight) {
            this.gapHeight = gapHeight;
            return this;
        }

        public WaterMark build() {
            return new WaterMark(this);
        }
    }

    public interface WriteWaterMarkInterface {
        /**
         * 写入水印
         *
         * @param width      原始图片宽
         * @param height     原始图片高
         * @param graphics2d 合成后图片
         */
        void writeText(int width, int height, Graphics2D graphics2d);
    }

    /**
     * 添加单条文字水印
     *
     * @param is   输入图片流
     * @param os   输出图片流
     * @param text 输入水印文字
     * @param x    输入水印文字x坐标
     * @param y    输入水印文字y坐标
     */
    public void textWaterMark(InputStream is, OutputStream os, String text, int x, int y) throws IOException {
        waterMarkGenerator(is, os, (width, height, graphics2d) -> {
            //计算文字水印宽高值
            int waterWidth = fontSize * getTextLength(text);
            int waterHeight = fontSize;
            //计算水印与原图高宽差
            int widthDiff = width - waterWidth;
            int heightDiff = height - waterHeight;
            //水印坐标设置
            graphics2d.drawString(text, x > widthDiff ? widthDiff : x, y > heightDiff ? heightDiff : y);
        });
    }

    /**
     * 添加多条文字水印
     *
     * @param is   输入图片流
     * @param os   输出图片流
     * @param text 输入水印文字
     * @throws IOException
     */
    public void moreTextWaterMark(InputStream is, OutputStream os, String text) throws IOException {
        waterMarkGenerator(is, os, (width, height, graphics2d) -> {
            //计算文字水印宽高值
            int waterWidth = fontSize * getTextLength(text);
            int waterHeight = fontSize;
            int x = -width / 2;
            int y;
            while (x < width * 1.5) {
                y = -height / 2;
                while (y < height * 1.5) {
                    graphics2d.drawString(text, x, y);
                    y += waterHeight + gapHeight;
                }
                x += waterWidth + gapWidth;
            }
        });
    }


    public void waterMarkGenerator(InputStream is, OutputStream os, WriteWaterMarkInterface minterface) throws IOException {
        Image image = ImageIO.read(is);
        //计算原始图片宽度长度
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        //创建图片缓存对象
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //创建java绘图工具对象
        Graphics2D graphics2d = bufferedImage.createGraphics();
        //参数主要是，原图，坐标，宽高
        graphics2d.drawImage(image, 0, 0, width, height, null);
        graphics2d.setFont(new Font(fontName, fontStyle, fontSize));
        graphics2d.setColor(fontColor);
        //水印透明设置
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        graphics2d.rotate(Math.toRadians(rotateAngle), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

        minterface.writeText(width, height, graphics2d);
        graphics2d.dispose();

        ImageIO.write(bufferedImage, "jpg", os);
    }

    /**
     * 计算水印文本长度
     * 1、中文长度即文本长度 2、英文长度为文本长度二分之一
     *
     * @param text
     * @return
     */
    public static int getTextLength(String text) {
        int length = text.length();
        for (int i = 0; i < text.length(); i++) {
            String s = String.valueOf(text.charAt(i));
            if (s.getBytes().length > 1) {
                length++;
            }
        }
        length = length % 2 == 0 ? length / 2 : length / 2 + 1;
        return length;
    }
}
