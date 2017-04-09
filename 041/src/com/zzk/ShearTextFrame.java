package com.zzk;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShearTextFrame extends JFrame {
    private ShearTextPanel shearTextPanel = new ShearTextPanel();
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShearTextFrame frame = new ShearTextFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public ShearTextFrame() {
        super();
        setBounds(100, 100, 365, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("倾斜效果的文字");
        getContentPane().add(shearTextPanel);
    }
    
    class ShearTextPanel extends JPanel { // 创建内部面板类
        public void paint(Graphics g) { // 重写paint()方法
            Graphics2D g2 = (Graphics2D)g;// 转换为Graphics2D类型
            String value = "编程词典";// 绘制的文本
            int x = 10; // 文本位置的横坐标
            int y = 170; // 文本位置的纵坐标
            Font font = new Font("华文行楷", Font.BOLD, 72); // 创建字体对象
            g2.setFont(font); // 设置字体
            g2.shear(0.1, -0.4);// 倾斜画布
            g2.drawString(value, x, y); // 绘制文本
        }
    }
}
