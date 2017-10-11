package com.sxc.utils.validatecode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 验证码生成器
 */
public class ValidateCode {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int s = random.nextInt(29) % (29 - 0 + 1) + 0;
            System.out.println(s);
        }
    }
    // 图片的宽度。
    private int width = 160;
    // 图片的高度。
    private int height = 40;
    // 验证码字符个数
    private int codeCount = 4;
    // 验证码干扰线数
    private int lineCount = 100;
    // 验证码
    private String code = null;

    // 验证码图片Buffer
    private BufferedImage buffImg = null;

    private List<Integer[]> rgbList = new LinkedList<Integer[]>();

    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

    public ValidateCode() {
        this.createCode();
    }

    /**
     * 
     * @param width
     *            图片宽
     * @param height
     *            图片高
     */
    public ValidateCode(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * 
     * @param width
     *            图片宽
     * @param height
     *            图片高
     * @param codeCount
     *            字符个数
     * @param lineCount
     *            干扰线条数
     */
    public ValidateCode(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        setRgbList();
        int x = 0, fontHeight = 0, codeY = 0;
        int red = 0, green = 0, blue = 0;

        x = width / (codeCount + 1);// 每个字符的宽度
        fontHeight = height - 1;// 字体的高度
        codeY = height - 8;

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 生成随机数
        Random random = new Random();
        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 创建字体
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);
        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }

        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);

            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。

            Integer[] rgb = getRedGreenBlue();
            red = rgb[0];
            green = rgb[1];
            blue = rgb[2];

            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x - 10, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        code = randomCode.toString();
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }

    /**
     * 获取颜色色值
     * 
     * @return
     */
    public Integer[] getRedGreenBlue() {
        Random random = new Random();
        // int red = 0, green = 0, blue = 0;
        // red = random.nextInt(255);
        // green = random.nextInt(255);
        // blue = random.nextInt(255);

        int index = random.nextInt(rgbList.size()) % (rgbList.size() - 0 + 1) + 0;

        return rgbList.get(index);
    }

    private void setRgbList() {
        rgbList.add(new Integer[] { 0, 0, 0 });// 黑色
        rgbList.add(new Integer[] { 102, 0, 153 });
        rgbList.add(new Integer[] { 41, 36, 33 });// 象牙黑
        rgbList.add(new Integer[] { 65, 105, 225 });// 品蓝
        rgbList.add(new Integer[] { 51, 0, 204 });
        rgbList.add(new Integer[] { 106, 90, 205 });// 石板蓝
        rgbList.add(new Integer[] { 0, 0, 51 });
        rgbList.add(new Integer[] { 56, 94, 15 });// 绿土
        rgbList.add(new Integer[] { 102, 0, 51 });
        rgbList.add(new Integer[] { 153, 0, 51 });
        rgbList.add(new Integer[] { 255, 97, 3 });// 镉橙
        rgbList.add(new Integer[] { 102, 0, 0 });
        rgbList.add(new Integer[] { 128, 42, 42 });// 棕色
        rgbList.add(new Integer[] { 34, 139, 34 });// 森林绿
        rgbList.add(new Integer[] { 255, 0, 0 });// 红色
        rgbList.add(new Integer[] { 227, 23, 13 });// 镉红
        rgbList.add(new Integer[] { 160, 32, 240 });// 紫色
        rgbList.add(new Integer[] { 178, 34, 34 });// 耐火砖红
        rgbList.add(new Integer[] { 0, 0, 255 });// 蓝色
        rgbList.add(new Integer[] { 94, 38, 18 });// 乌贼墨棕
        rgbList.add(new Integer[] { 176, 23, 31 });// 印度红
        rgbList.add(new Integer[] { 30, 144, 255 });
        rgbList.add(new Integer[] { 25, 25, 112 });// 深蓝色
        rgbList.add(new Integer[] { 255, 0, 255 });// 深红色
        rgbList.add(new Integer[] { 3, 168, 158 });// 锰蓝
        rgbList.add(new Integer[] { 61, 89, 171 });// 钴色
        rgbList.add(new Integer[] { 135, 38, 87 });// 草莓色
        rgbList.add(new Integer[] { 0, 51, 255 });
        rgbList.add(new Integer[] { 139, 105, 105 });
        rgbList.add(new Integer[] { 51, 51, 153 });
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public void write(String path) throws IOException {
        OutputStream sos = null;
        try {
            sos = new FileOutputStream(path);
            this.write(sos);
        } catch (IOException e) {
            throw e;
        } finally {
            if (null != sos) {
                sos.close();
            }
        }
    }
}
