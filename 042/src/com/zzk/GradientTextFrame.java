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
        setTitle("����Ч��������");
        getContentPane().add(gradientTextPanel);
    }
    
    class GradientTextPanel extends JPanel { // �����ڲ������
        public void paint(Graphics g) { // ��дpaint()����
            Graphics2D g2 = (Graphics2D) g;// ת��ΪGraphics2D����
            String value = "Javaȫ��";// ���Ƶ��ı�
            int x = 15; // �ı�λ�õĺ�����
            int y = 60; // �ı�λ�õ�������
            Font font = new Font("����", Font.BOLD, 60); // �����������
            g2.setFont(font); // ��������
            // ����ѭ�������GraphientPaint����
            GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100,120, Color.RED, true);
            g2.setPaint(paint);// ���ý���
            g2.drawString(value, x, y); // �����ı�
            font = new Font("�����п�", Font.BOLD, 60); // �����µ��������
            g2.setFont(font); // ��������
            x = 80; // �ı�λ�õĺ�����
            y = 130; // �ı�λ�õ�������
            value = "��̴ʵ�";// ���Ƶ��ı�
            g2.drawString(value, x, y); // �����ı�
        }
    }
}
