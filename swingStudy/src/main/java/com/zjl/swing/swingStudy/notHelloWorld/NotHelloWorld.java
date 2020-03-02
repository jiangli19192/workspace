package com.zjl.swing.swingStudy.notHelloWorld;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * ClassName : NotHelloWorld
 * @author 张江立
 * @date 2016年3月19日 下午11:37:28
 *
 */
public class NotHelloWorld {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new NotHelloWorldFrame();
				frame.setTitle("NotHelloWorld");
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class NotHelloWorldFrame extends JFrame {
	private static final long serialVersionUID = -3104402365903676723L;

	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent());
		setFrameCentering();
		pack();
	}
	
	/**
	 * 设置框架屏幕居中
	 */
	private void setFrameCentering(){
		// 获取屏幕大小
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();
		int screenWidth = (int) dimension.getWidth();
		int screenHeight = (int) dimension.getHeight();
		// 设置组件打开在屏幕居中位置开始打开
		setLocation(screenWidth / 4, screenHeight / 4);
	}
}

/**
 * A component that displays a message
 * 显示信息的一个组件
 * @author 张江立
 */
class NotHelloWorldComponent extends JComponent {
	private static final long serialVersionUID = 5281950566739493374L;
	
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	/**
	 * 绘画(paint)组件
	 * 图形(graphics)
	 */
	public void paintComponent (Graphics g) {
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
	
	/**
	 * 获取首选的(preferred)尺寸(dimension)
	 */
	public Dimension getPreferredSize () {
		Dimension dimension = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		return dimension;
	}
}
