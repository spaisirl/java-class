package Prac1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorArc3 extends JFrame {
	
	PaintPanel pnl = new PaintPanel();
	
	public ColorArc3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("");
		setContentPane(pnl);
		
		setVisible(true);
	}
	
	public class PaintPanel extends JPanel {
		private Color[] colors = {
				Color.RED, Color.BLUE, Color.YELLOW
		};
		private int startAngles = 90;
		private static final int CIRCLE_SIZE = 200;
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			int panelX = this.getWidth() /2;
			int panelY = this.getHeight() /2;
			int centerX = panelX - (CIRCLE_SIZE /2);
			int centerY = panelY - (CIRCLE_SIZE /2);
			
			for (int i =0; i < colors.length; i++) {
				
				int rotate = (360 / colors.length);
				g.setColor(colors[i]);
				g.fillArc(centerX, centerY, 200, 200, startAngles, rotate);
				startAngles += rotate;
			}
			
			/*
			g.setColor(Color.BLACK);
			g.drawArc(200, 150, 100, 100, 90, 360);
			g.setColor(Color.RED);
			g.fillArc(200, 150, 100, 100, 90, 120); 
			g.setColor(Color.YELLOW);
			g.fillArc(200, 150, 100, 100, 90, -120); 
			g.setColor(Color.BLUE);
			g.fillArc(200, 150, 100, 100, -150, 120); //0도 부터 120도
			*/
		}
	} 
	
	public static void main(String[] args) {
		new ColorArc3();
	}

}
