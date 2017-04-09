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
        setTitle("����Ч��������");
        getContentPane().add(solidTextPanel);
    }
    class SolidTextPanel extends JPanel { // �����ڲ������
        public void paint(Graphics g) { // ��дpaint()����
            String value = "���տƼ�";
            int x = 16; // �ı�λ�õĺ�����
            int y = 100; // �ı�λ�õ�������
            Font font = new Font("����", Font.BOLD, 72); // �����������
            g.setFont(font); // ��������
            g.setColor(Color.GRAY);// ������ɫΪ��ɫ
            int i = 0;// ѭ������
            while (i<8){
                g.drawString(value, x, y); // �����ı�
                x+=1;// �������Ƶ�ĺ�����ֵ
                y+=1;// �������Ƶ��������ֵ
                i++;// ����ѭ��������ֵ
            }
            g.setColor(Color.BLACK);// ������ɫ��ɫ
            g.drawString(value, x, y); // �����ı�
        }
    }
}
