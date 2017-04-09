package com.zzk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientTextFrame extends JFrame {
    private GradientTextPanel gradientTextPanel = new GradientTextPanel();
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GradientTextFrame frame = new GradientTextFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public GradientTextFrame() {
        super();
        setBounds(100, 100, 365, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("渐变效果的文字");
        getContentPane().add(gradientTextPanel);
    }
    
    class GradientTextPanel extends JPanel { // 创建内部面板类
        public void paint(Graphics g) { // 重写paint()方法
            Graphics2D g2 = (Graphics2D) g;// 转换为Graphics2D类型
            String value = "Java全能";// 绘制的文本
            int x = 15; // 文本位置的横坐标
            int y = 60; // 文本位置的纵坐标
            Font font = new Font("楷体", Font.BOLD, 60); // 创建字体对象
            g2.setFont(font); // 设置字体
            // 创建循环渐变的GraphientPaint对象
            GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100,120, Color.RED, true);
            g2.setPaint(paint);// 设置渐变
            g2.drawString(value, x, y); // 绘制文本
            font = new Font("华文行楷", Font.BOLD, 60); // 创建新的字体对象
            g2.setFont(font); // 设置字体
            x = 80; // 文本位置的横坐标
            y = 130; // 文本位置的纵坐标
            value = "编程词典";// 绘制的文本
            g2.drawString(value, x, y); // 绘制文本
        }
    }
}
