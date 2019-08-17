package com.project.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCode {

    //创建一个随机数对象
    Random ran = new Random();
    //定义一个图片的大小
    private int width = 100;
    private int height = 40;
    //定义一个字体集合
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    //定义可选字符集合
    private String codes = "23456789zxcvbnmasdfghjkqwertyupZXCVBNMASDFGHJKQWERTYUP";
    //定义一个背景颜色
    private Color bgColor = new Color(255, 255, 255);
    //创建验证码上的文本
    private String text;

    /**
     * 保存图片到指定输出流中
     * @param image 验证码图片
     * @param out 输出流
     * @throws IOException IO流异常
     */
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

    /**
     * 生成随机颜色
     * @return 画笔颜色
     */
    private Color randomColor() {
        //把三原色参数远离背景颜色三原色参数
        int rad = ran.nextInt(150);
        int green = ran.nextInt(150);
        int blue = ran.nextInt(150);
        return new Color(rad, green, blue);
    }

    /**
     * 生成随机字体
     * @return 字体
     */
    private Font randomFont() {
        int index = ran.nextInt(fontNames.length);
        String fontName = fontNames[index];//生成随机字体的名称
        int style = ran.nextInt(3);//生成随机字体的样式，0(无样式)1：粗体，2：斜体，3:粗斜体
        int size = ran.nextInt(5) + 25;//生成随机字体的字号
        return new Font(fontName, style, size);

    }

    /**
     * 随机绘制干扰线
     * @param image 干扰线
     */
    private void drawLine(BufferedImage image) {
        //一共画三条线
        int num = 1;
        //得到绘制环境
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //生成两个点，即四个坐标值
        for (int i = 0; i < num; i++) {
            int x1 = ran.nextInt(width - 65);
            int y1 = ran.nextInt(height - 10) + 5;
            int x2 = ran.nextInt(5) + 65;
            int y2 = ran.nextInt(height);
            //设置干扰线是蓝色
            g2.setColor(Color.BLUE);
            //画线
            g2.drawLine(x1, y1, x1 + x2, y1 + y2);
        }

    }

    /**
     * 随机生成一个字符
     * @return 字符
     */
    private char randomChar() {
        int index = ran.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 创建BufferedImage
     * @return BufferedImage
     */
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 用这个方法得到验证码图片
     * @return 验证码图片
     */
    public BufferedImage getImage() {
        //创建图片缓冲区
        BufferedImage image = createImage();
        //得到绘制环境
        Graphics2D g = (Graphics2D) image.getGraphics();
        //用来装载生成的验证码文本
        StringBuffer sb = new StringBuffer();
        //向图片中绘制出四个字符
        for (int i = 0; i < 4; i++) {
            //随机生成一个字母
            String s = randomChar() + "";
            //将字母添加到StringBuffer中
            sb.append(s);
            //设置当前字符的X轴坐标
            float x = i * 1.0F * width / 4;
            //设置随机字体
            g.setFont(randomFont());
            //设置随机颜色
            g.setColor(randomColor());
            //画图
            g.drawString(s, x, height - 15);
        }
        //把随机生成的字符串赋给this.text
        this.text = sb.toString();
        //添加干扰线
        drawLine(image);
        return image;
    }

    /**
     * 返回验证码图片上的文本
     * @return 文本
     */
    public String getText() {
        return text;
    }
}
