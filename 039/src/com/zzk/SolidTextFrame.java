package com.zzk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SolidTextFrame extends JFrame {
    private SolidTextPanel solidTextPanel = new SolidTextPanel();
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SolidTextFrame frame = new SolidTextFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public SolidTextFrame() {
        super();
        setBounds(100, 100, 354, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("立体效果的文字");
        getContentPane().add(solidTextPanel);
    }
    class SolidTextPanel extends JPanel { // 创建内部面板类
        public void paint(Graphics g) { // 重写paint()方法
            String value = "明日科技";
            int x = 16; // 文本位置的横坐标
            int y = 100; // 文本位置的纵坐标
            Font font = new Font("宋体", Font.BOLD, 72); // 创建字体对象
            g.setFont(font); // 设置字体
            g.setColor(Color.GRAY);// 设置颜色为灰色
            int i = 0;// 循环变量
            while (i<8){
                g.drawString(value, x, y); // 绘制文本
                x+=1;// 调整绘制点的横坐标值
                y+=1;// 调整绘制点的纵坐标值
                i++;// 调整循环变量的值
            }
            g.setColor(Color.BLACK);// 设置颜色黑色
            g.drawString(value, x, y); // 绘制文本
        }
    }
}
