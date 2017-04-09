package com.zzk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeColorTextFrame extends JFrame {
    private ChangeColorTextPanel changeColorTextPanel = new ChangeColorTextPanel();

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeColorTextFrame frame = new ChangeColorTextFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        ChangeColorTextFrame frame=new ChangeColorTextFrame();
//        frame.setVisible(true);
}

    public ChangeColorTextFrame() {
        super();
        setBounds(100, 100, 400, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("会变色的文字");
        getContentPane().add(changeColorTextPanel);
        Thread thread = new Thread(changeColorTextPanel);// 创建线程对象
        thread.start();// 启动线程对象
    }

    class ChangeColorTextPanel extends JPanel implements Runnable { // 创建内部面板类
        Color color = new Color(0, 0, 255);

        public void paint(Graphics g) { // 重写paint()方法
            Graphics2D g2 = (Graphics2D) g;// 转换为Graphics2D类型
            String value = "《视频学Java编程》";// 绘制的文本
            int x = 2; // 文本位置的横坐标
            int y = 90; // 文本位置的纵坐标
            Font font = new Font("楷体", Font.BOLD, 40); // 创建字体对象
            g2.setFont(font); // 设置字体
            g2.setColor(color);// 设置颜色
            g2.drawString(value, x, y); // 绘制文本
        }

        public void run() {
            Random random = new Random();// 创建随机数对象
            while (true) {
                int R = random.nextInt(256);// 随机产生颜色的R值
                int G = random.nextInt(256);// 随机产生颜色的G值
                int B = random.nextInt(256);// 随机产生颜色的B值
                color = new Color(R, G, B);// 创建颜色对象
                repaint();// 调用paint()方法
                try {
                    Thread.sleep(300);// 休眠300毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
