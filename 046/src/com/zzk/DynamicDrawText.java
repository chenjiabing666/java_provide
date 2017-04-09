package com.zzk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.*;

import javax.swing.*;

public class DynamicDrawText extends JFrame {
    private DynamicDrawTextPanel dynamicDrawTextPanel = new DynamicDrawTextPanel();
    public static void main(String args[]) {
        DynamicDrawText frame;
        try {
            frame = new DynamicDrawText();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public DynamicDrawText() {
        setTitle("动态绘制文本");
        setBounds(100, 100, 262, 179);
        setDefaultCloseOperation(3);
        getContentPane().add(dynamicDrawTextPanel);
        Thread thread = new Thread(dynamicDrawTextPanel); // 创建线程对象
        thread.start(); // 启动线程
    }
    
    // 创建面板类
    class DynamicDrawTextPanel extends JPanel implements Runnable {
        private BufferedReader read; // 声明缓冲流对象
        int x = 20;// 起始点的x坐标
        int y = 30;// 起始点的y坐标
        String value = "";
        public DynamicDrawTextPanel(){
            String projectPath = System.getProperty("user.dir"); // 获得当前项目
            String filePath = projectPath + "/src/com/zzk/dyn.txt";// 获得项目中loadText.java文件的完整路径
            InputStream in = null;
            try {
                in = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // 创建输入流对象
            read = new BufferedReader(new InputStreamReader(in)); // 创建缓冲流对象
        }
        public void paint(Graphics g) {
            Font font = new Font("华文楷体", Font.BOLD, 20);// 创建字体对象
            g.setFont(font);// 指定字体
            g.setColor(Color.RED);// 指定颜色
            g.drawString(value, x, y);// 绘制文本
        }
        public void run() {
            int len = 0;// 存储读取的字符
            try {
                while ((len = read.read()) != -1) { // 读取内容
                    Thread.sleep(400); // 当前线程休眠400毫秒
                    value = String.valueOf((char) len); // 获得读取的内容
                    if (value.equals("\n") || value.equals("\r")) {// 是回车或换行符
                        x = 20;// 下一行起始点的x坐标
                        y += 15;// 下一行文本的y坐标
                    } else {// 不是回车或换行符
                        x += 20;// 当前行下一个字的x坐标
                    }
                    repaint();// 调用paint()方法
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}