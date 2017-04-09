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
    private Image img = null;  // 声明图像对象
    private WatermarkTextPanel watermarkTextPanel = null;  // 声明图像面板对象
    public static void main(String args[]) {
        WatermarkTextFrame frame = new WatermarkTextFrame();
        frame.setVisible(true);
    }
    public WatermarkTextFrame() {
        super();
        URL imgUrl = WatermarkTextFrame.class.getResource("/img/image.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图像资源
        watermarkTextPanel = new WatermarkTextPanel();  // 创建图像面板对象
        this.setBounds(200, 160, 316, 237); // 设置窗体大小和位置
        this.add(watermarkTextPanel); // 在窗体上添加图像面板对象
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("水印文字特效"); // 设置窗体标题
    }
    // 创建面板类
    class WatermarkTextPanel extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;// 获得Graphics2D对象
            g2.drawImage(img, 0, 0, 300, 237, this);// 绘制图像
            g2.rotate(Math.toRadians(-30));// 旋转绘图上下文对象
            Font font = new Font("楷体",Font.BOLD,60);// 创建字体对象
            g2.setFont(font);//指定字体
            g2.setColor(Color.WHITE);// 指定颜色
           // AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.3f);// 获得表示透明度的AlphaComposite对象
            AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f);
            g2.setComposite(alpha);// 指定AlphaComposite对象
            g2.drawString("编程词典", -60, 180);// 绘制文本,实现水印
        }
    }
}
