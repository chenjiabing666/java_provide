package com.zzk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShadowTextFrame extends JFrame {
    private ShadowTextPanel shadowTextPanel = new ShadowTextPanel();
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShadowTextFrame frame = new ShadowTextFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public ShadowTextFrame() {
        super();
        setBounds(100, 100, 354, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("��ӰЧ��������");
        getContentPane().add(shadowTextPanel);
    }
    
    class ShadowTextPanel extends JPanel { // �����ڲ������
        public void paint(Graphics g) { // ��дpaint()����
            String value = "��̴ʵ�";
            int x = 16; // �ı�λ�õĺ�����
            int y = 100; // �ı�λ�õ�������
            Font font = new Font("�����п�", Font.BOLD, 72); // �����������
            g.setFont(font); // ��������
            g.setColor(Color.GRAY);// ������ɫΪ��ɫ
            int i = 0;// ѭ������
            g.drawString(value, x, y); // �����ı�
            x -= 3;// �������Ƶ�ĺ�����ֵ
            y -= 3;// �������Ƶ��������ֵ
            g.setColor(Color.BLACK);// ������ɫ��ɫ
            g.drawString(value, x, y); // �����ı�
        }
    }
}
