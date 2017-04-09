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
        setTitle("��бЧ��������");
        getContentPane().add(shearTextPanel);
    }
    
    class ShearTextPanel extends JPanel { // �����ڲ������
        public void paint(Graphics g) { // ��дpaint()����
            Graphics2D g2 = (Graphics2D)g;// ת��ΪGraphics2D����
            String value = "��̴ʵ�";// ���Ƶ��ı�
            int x = 10; // �ı�λ�õĺ�����
            int y = 170; // �ı�λ�õ�������
            Font font = new Font("�����п�", Font.BOLD, 72); // �����������
            g2.setFont(font); // ��������
            g2.shear(0.1, -0.4);// ��б����
            g2.drawString(value, x, y); // �����ı�
        }
    }
}
