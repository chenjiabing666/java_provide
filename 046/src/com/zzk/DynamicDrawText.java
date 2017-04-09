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
        setTitle("��̬�����ı�");
        setBounds(100, 100, 262, 179);
        setDefaultCloseOperation(3);
        getContentPane().add(dynamicDrawTextPanel);
        Thread thread = new Thread(dynamicDrawTextPanel); // �����̶߳���
        thread.start(); // �����߳�
    }
    
    // ���������
    class DynamicDrawTextPanel extends JPanel implements Runnable {
        private BufferedReader read; // ��������������
        int x = 20;// ��ʼ���x����
        int y = 30;// ��ʼ���y����
        String value = "";
        public DynamicDrawTextPanel(){
            String projectPath = System.getProperty("user.dir"); // ��õ�ǰ��Ŀ
            String filePath = projectPath + "/src/com/zzk/dyn.txt";// �����Ŀ��loadText.java�ļ�������·��
            InputStream in = null;
            try {
                in = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // ��������������
            read = new BufferedReader(new InputStreamReader(in)); // ��������������
        }
        public void paint(Graphics g) {
            Font font = new Font("���Ŀ���", Font.BOLD, 20);// �����������
            g.setFont(font);// ָ������
            g.setColor(Color.RED);// ָ����ɫ
            g.drawString(value, x, y);// �����ı�
        }
        public void run() {
            int len = 0;// �洢��ȡ���ַ�
            try {
                while ((len = read.read()) != -1) { // ��ȡ����
                    Thread.sleep(400); // ��ǰ�߳�����400����
                    value = String.valueOf((char) len); // ��ö�ȡ������
                    if (value.equals("\n") || value.equals("\r")) {// �ǻس����з�
                        x = 20;// ��һ����ʼ���x����
                        y += 15;// ��һ���ı���y����
                    } else {// ���ǻس����з�
                        x += 20;// ��ǰ����һ���ֵ�x����
                    }
                    repaint();// ����paint()����
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}