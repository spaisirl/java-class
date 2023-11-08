package ex02;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GraphicsDrawImageEx extends JFrame {
	
	public GraphicsDrawImageEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(500,500);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	public class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("images/cat.png");
		private Image image = icon.getImage();
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			//g.drawImage(image, 20, 20, this); //원본크기로 지정
			//g.drawImage(image, 20, 20, 400, 300, this); // 400 x 300
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // 패널 크기에 맞춰 그리기
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawImageEx();

	}

}
