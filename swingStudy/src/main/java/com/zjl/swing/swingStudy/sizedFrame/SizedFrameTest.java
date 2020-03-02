package com.zjl.swing.swingStudy.sizedFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author 张江立
 *
 */
public class SizedFrameTest {
	public static void main(String[] args) {
		// 事件分配线程(event dispatch thread)
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SizedFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭响应动作
				frame.setVisible(true);// 显示框架
			}
		});
	}
}

@SuppressWarnings("serial")
class SizedFrame extends JFrame {
	public SizedFrame() {
		// 获取屏幕大小
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();
		int screenWidth = (int) dimension.getWidth();
		int screenHeight = (int) dimension.getHeight();

		// 设置frame宽度、高度，让平台获取屏幕位置
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);

		// 设置框架图标
		Image img = new ImageIcon("src/main/resources/image/logo.png")
				.getImage();
		setIconImage(img);
		
		// 设置组件打开的位置
		setLocation(screenWidth / 4, screenHeight / 4);
	}
}