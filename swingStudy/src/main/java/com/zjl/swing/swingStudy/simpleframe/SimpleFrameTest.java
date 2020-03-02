package com.zjl.swing.swingStudy.simpleframe;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 显示一个空框架
 * @author 张江立
 *
 */
public class SimpleFrameTest {
	public static void main(String[] args) {
		// 事件分配线程(event dispatch thread)
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setTitle("最简单的可见框架");// 设置标题栏的文字
				frame.setResizable(false);// 不允许改变框架大小
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭响应动作
				frame.setVisible(true);// 显示框架
			}
		});
	}
}

class SimpleFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 500;
	
	public SimpleFrame() {
//		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		Toolkit toolkit = getToolkit();// 获得窗体工具包
        Dimension screenSize = toolkit.getScreenSize();// 获取屏幕大小
//        int width = (int) (screenSize.width * 0.8);// 计算窗体新宽度
//        int height = (int) (screenSize.height * 0.8);// 计算窗体新宽度
//        setSize(width, height);// 重新设置窗体大小
        
        System.out.println("width=" + screenSize.getWidth() + ";  height=" + screenSize.getHeight());
        
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        
        System.out.println("width=" + screenWidth + ";  height=" + screenHeight);
        
        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);
        
        Image image = new ImageIcon("src/main/resources/image/logo.png").getImage();
        setIconImage(image);
        		
	}
}
