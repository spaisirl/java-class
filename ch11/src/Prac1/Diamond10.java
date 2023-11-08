package Prac1;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Diamond10 extends JFrame{
	
	Panel diamond = new Panel();
	
	public Diamond10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("");
		setContentPane(diamond);
		
		setVisible(true);
		
	}
	
	public class Panel extends JPanel {
		
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			int width = this.getWidth();
			int height = this.getHeight();
			
			int x [] = {width/2,0,width/2,width};
			int y [] = {0,height/2,height,height/2};
			g.drawPolygon(x, y,  x.length);
			
			
			int xs = (int)this.getWidth()/30;
			int ys = (int)this.getHeight()/30;
			g.drawPolygon(x, y,  x.length);
			
						
			x[0] = getWidth()/2; y[0] = 0;
			x[1] = 0; y[1] = getHeight()/2;
			x[2] = getWidth()/2; y[2] = getHeight();
			x[3] = getWidth(); y[3] = getHeight()/2;
			
			
			
			for (int i =0; i < 10; i++) {
				
				y[0] += ys;
				x[1] += xs;
				y[2] -= ys;
				x[3] -= xs;
				
				g.drawPolygon(x, y,  x.length);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Diamond10();

	}

}
