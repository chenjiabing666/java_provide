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
        setTitle("���ɫ������");
        getContentPane().add(changeColorTextPanel);
        Thread thread = new Thread(changeColorTextPanel);// �����̶߳���
        thread.start();// �����̶߳���
    }

    class ChangeColorTextPanel extends JPanel implements Runnable { // �����ڲ������
        Color color = new Color(0, 0, 255);

        public void paint(Graphics g) { // ��дpaint()����
            Graphics2D g2 = (Graphics2D) g;// ת��ΪGraphics2D����
            String value = "����ƵѧJava��̡�";// ���Ƶ��ı�
            int x = 2; // �ı�λ�õĺ�����
            int y = 90; // �ı�λ�õ�������
            Font font = new Font("����", Font.BOLD, 40); // �����������
            g2.setFont(font); // ��������
            g2.setColor(color);// ������ɫ
            g2.drawString(value, x, y); // �����ı�
        }

        public void run() {
            Random random = new Random();// �������������
            while (true) {
                int R = random.nextInt(256);// ���������ɫ��Rֵ
                int G = random.nextInt(256);// ���������ɫ��Gֵ
                int B = random.nextInt(256);// ���������ɫ��Bֵ
                color = new Color(R, G, B);// ������ɫ����
                repaint();// ����paint()����
                try {
                    Thread.sleep(300);// ����300����
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
