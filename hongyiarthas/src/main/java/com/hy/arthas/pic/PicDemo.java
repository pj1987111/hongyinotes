package com.hy.arthas.pic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class PicDemo {
    private static Map<RoadKey, List<DrawObj>> roadPaintMap = new HashMap<>();
    private static File output = new File("/home/admin/zhy/arthastest/1.bmp");

    static {
        List<DrawObj> valsa = roadPaintMap.computeIfAbsent(new RoadKey("a", Color.GREEN), k -> new ArrayList<>());
        valsa.add(new DrawObj(45, 3, 9, 24));
        valsa.add(new DrawObj(45, 3 + 24, 9, 20));
        valsa.add(new DrawObj(45, 3 + 24 + 20, 9, 5));
        valsa.add(new DrawObj(45, 3 + 24 + 20 + 5, 9, 11));

        List<DrawObj> valsb = roadPaintMap.computeIfAbsent(new RoadKey("b", Color.GREEN), k -> new ArrayList<>());
        valsb.add(new DrawObj(45, 3 + 60, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 4, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 8, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 12, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 16, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 20, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 24, 9, 4));
        valsb.add(new DrawObj(45, 3 + 60 + 28, 9, 4));

        List<DrawObj> valsc = roadPaintMap.computeIfAbsent(new RoadKey("c", Color.GREEN), k -> new ArrayList<>());
        valsc.add(new DrawObj(45, 3 + 60 + 32, 9, 6));
        valsc.add(new DrawObj(45, 3 + 60 + 38, 9, 6));
        valsc.add(new DrawObj(45, 3 + 60 + 38 + 6, 9, 6));
    }

    public static void repaint() {
        BufferedImage bi = new BufferedImage(324, 130, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setColor(Color.GREEN);
        drawArchLeftUp(g2d, 45, 20, 120, 90, 100, 101);

        /**红垦-杭州绕城萧山东开始**/
        java.util.List<String> dblocks = new ArrayList<>();
        dblocks.add("010214NDU0976E014ND809720009_010214ND809720014NC3096VE001");
        dblocks.add("010214ND809720014NC3096VE001_010214NC3096VE014MO4095S30094");
        dblocks.add("010214NC3096VE014MO4095S30094_010214NC3096VE014MO4095S300118");
        dblocks.add("010214NC3096VE014MO4095S300118_010214NC3096VE014MO4095S300141");
//        Color c = (getColorByAvgBlockIndex(dblocks));
        g2d.setPaint(Color.orange);
        drawArchLeftUpLeft(g2d, 7, 13, 74, 74, 0, 75);
        g2d.setPaint(Color.orange);
        g2d.fillRect(5, 14, 42, 8);
        g2d.setPaint(Color.GREEN);
        /**红垦-杭州绕城萧山东结束**/

        /**红垦-下沙枢纽开始**/
        java.util.List<String> xblocks = new ArrayList<>();
        xblocks.add("010214NDV09775014NE3097UD0026_010214NDV09775014NE3097UD0048");
        xblocks.add("010214NDV09775014NE3097UD0048_010214NDV09775014NE3097UD0070");
        xblocks.add("010214NDV09775014NE3097UD0070_010214NE3097UD014NEO097VQ001");
        xblocks.add("010214NE3097UD014NEO097VQ001_010214NFP0982L014NEA0984E003");
        g2d.setPaint(Color.blue);
        drawArchLeftUp(g2d, 45, 20, 120, 90, 100, 101);
//        g2d.setPaint(Color.red);
//        drawArchLeftUp(g2d, 45, 20,120,90,20,101);
        java.util.List<String> xblocks1 = new ArrayList<>();
        /*xblocks1.add("010214ND40971K014NDV09775009_010214NDV09775014NE3097UD002");
        xblocks1.add("010214NDV09775014NE3097UD002_010214NDV09775014NE3097UD0026");
        g2d.setPaint(getColorByAvgBlockIndex(xblocks1
        ));*/

        //拆分
        g2d.setPaint(Color.blue);
        g2d.fillRect(55, 40, 1, 18);
        g2d.fillRect(56, 39, 1, 15);
        g2d.fillRect(57, 38, 1, 15);
        g2d.fillRect(58, 37, 1, 14);
        g2d.setPaint(Color.orange);
        g2d.fillRect(59, 36, 1, 14);
        g2d.fillRect(60, 35, 1, 13);
        g2d.fillRect(61, 34, 1, 13);
        g2d.fillRect(62, 33, 1, 12);
        g2d.fillRect(63, 33, 1, 12);
        g2d.fillRect(64, 32, 1, 12);
        g2d.fillRect(65, 31, 1, 12);
        g2d.setPaint(Color.red);
        g2d.fillRect(66, 31, 1, 11);
        g2d.fillRect(67, 30, 1, 11);
        g2d.fillRect(68, 29, 1, 11);
        g2d.fillRect(69, 28, 1, 11);
        g2d.fillRect(70, 28, 1, 10);
        g2d.fillRect(71, 27, 1, 10);
        g2d.setPaint(Color.GREEN);
        /**红垦-下沙枢纽结束**/

        /**齐贤-钱江通道开始**/
        drawArchLeftDown(g2d, 46, 82, 60, 60, 120, 160);
        g2d.setPaint(Color.yellow);
        g2d.fillRect(55, 90, 1, 14);
        g2d.fillRect(58, 89, 1, 12);
        g2d.fillRect(61, 86, 1, 11);
        g2d.fillRect(65, 84, 1, 10);
        g2d.fillRect(68, 83, 1, 9);
        g2d.fillRect(71, 82, 1, 8);
        //g2d.setPaint(getColorByBlockIndex("S000933003000220010","4013"));
        g2d.setPaint(Color.green);
        g2d.fillRect(74, 82, 1, 8);
        /**齐贤-钱江通道结束**/

        /**主线路开始**/

        g2d.setPaint(Color.GREEN);
        for (Map.Entry<RoadKey, List<DrawObj>> valEntry : roadPaintMap.entrySet()) {
            g2d.setPaint(valEntry.getKey().color);
            for (DrawObj drawObj : valEntry.getValue()) {
                g2d.fillRect(drawObj.x, drawObj.y, drawObj.width, drawObj.height);
            }
        }
        /**主线路结束**/

        /**剔除毛刺开始**/
        g2d.setPaint(Color.black);
        g2d.fillRect(55, 60, 2, 20);
        g2d.fillRect(76, 53, 40, 50);
        g2d.fillRect(55, 104, 10, 4);
        /**剔除毛刺结束**/

        g2d.setPaint(Color.YELLOW);
        g2d.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        //用正文颜色覆盖上去
        g2d.drawString("红垦枢纽", 75, 14);
        g2d.drawString("钱江通道", 75, 109);
        g2d.setPaint(Color.GREEN);
        g2d.setFont(new Font("font", Font.PLAIN, 28));
        /*g2d.drawString("谨慎驾驶", 180, 50);
        g2d.drawString("注意安全", 180, 84);*/
//        g2d.drawString("前方畅通", 168, 50);
        g2d.drawString("前方畅通", 168, 60);


        try {
            ImageIO.write(bi, "bmp", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        repaint();
        System.out.println("end");
    }

    private static void drawArchLeftDown(Graphics2D g2d, int x, int y, int width, int height, int startAngle, int arcAngle) {
        g2d.drawArc(x, y, width, height, 0, arcAngle);
        g2d.fillArc(x, y, width, height, 0, arcAngle);
        g2d.setPaint(Color.black);
        g2d.fillArc(54, y + 6, width, height, 0, 180);
        g2d.setPaint(Color.GREEN);
    }

    private static void drawArchLeftUpLeft(Graphics2D g2d, int x, int y, int width, int height, int startAngle, int arcAngle) {
        g2d.drawArc(x, y, width, height, startAngle, arcAngle);
        g2d.fillArc(x, y, width, height, startAngle, arcAngle);
        g2d.setPaint(Color.black);
        g2d.fillArc(x + 9, y + 9, width - 15, height - 15, 0, 360);
        g2d.setPaint(Color.GREEN);
    }

    private static void drawArchLeftUp(Graphics2D g2d, int x, int y, int width, int height, int startAngle, int arcAngle) {
        g2d.drawArc(x, y, width, height, startAngle, arcAngle);
        g2d.fillArc(x, y, width, height, startAngle, arcAngle);
        g2d.setPaint(Color.black);
        g2d.fillArc(53, y + 6, width - 4, height - 4, 0, 360);
        g2d.setPaint(Color.GREEN);
    }

    private static void drawPolygon(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon polygon = new Polygon();
        polygon.addPoint(x1, y1);
        polygon.addPoint(x2, y2);
        polygon.addPoint(x3, y3);
        g2d.drawPolygon(polygon);
        g2d.fillPolygon(polygon);
    }

    private static String tansDate(String str) {
        int b = str.length();

        StringBuilder sb = new StringBuilder(str);
        if (sb.length() < 14) {
            int lengths = 14 - str.length();
            for (int a = 1; a <= lengths; a++) {
                sb = sb.insert(8, "0");
            }
        }
        System.out.println("2222  -> " + str);
        String dataStr = sb.insert(4, "-")
            .insert(7, "-")
            .insert(10, " ")
            .insert(13, ":")
            .insert(16, ":").toString();

        return dataStr;
    }

    private static class RoadKey {
        //路段名
        String key;
        //路段颜色
        Color color;

        RoadKey(String key, Color color) {
            this.key = key;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoadKey roadKey = (RoadKey) o;
            return Objects.equals(key, roadKey.key) &&
                Objects.equals(color, roadKey.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, color);
        }
    }

    private static class DrawObj {
        int x;
        int y;
        int width;
        int height;

        DrawObj(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
