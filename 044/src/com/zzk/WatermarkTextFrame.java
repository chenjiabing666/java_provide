package com.zzk;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WatermarkTextFrame extends JFrame {
    private Image img = null;  // ����ͼ�����
    private WatermarkTextPanel watermarkTextPanel = null;  // ����ͼ��������
    public static void main(String args[]) {
        WatermarkTextFrame frame = new WatermarkTextFrame();
        frame.setVisible(true);
    }
    public WatermarkTextFrame() {
        super();
        URL imgUrl = WatermarkTextFrame.class.getResource("/img/image.jpg");// ��ȡͼƬ��Դ��·��
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // ��ȡͼ����Դ
        watermarkTextPanel = new WatermarkTextPanel();  // ����ͼ��������
        this.setBounds(200, 160, 316, 237); // ���ô����С��λ��
        this.add(watermarkTextPanel); // �ڴ��������ͼ��������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���ر�ģʽ
        this.setTitle("ˮӡ������Ч"); // ���ô������
    }
    // ���������
    class WatermarkTextPanel extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;// ���Graphics2D����
            g2.drawImage(img, 0, 0, 300, 237, this);// ����ͼ��
            g2.rotate(Math.toRadians(-30));// ��ת��ͼ�����Ķ���
            Font font = new Font("����",Font.BOLD,60);// �����������
            g2.setFont(font);//ָ������
            g2.setColor(Color.WHITE);// ָ����ɫ
           // AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.3f);// ��ñ�ʾ͸���ȵ�AlphaComposite����
            AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f);
            g2.setComposite(alpha);// ָ��AlphaComposite����
            g2.drawString("��̴ʵ�", -60, 180);// �����ı�,ʵ��ˮӡ
        }
    }
}
