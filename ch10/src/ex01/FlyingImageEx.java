package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingImageEx extends JFrame {
	
	private Container con = getContentPane();
	private JLabel label = new JLabel(new ImageIcon("images/left.png"));
	private static final int MOVE_UNIT = 10;
	private ImageIcon iconRight = new ImageIcon("images/right.png");
	private ImageIcon iconLeft = new ImageIcon("images/left.png");
	
	public FlyingImageEx() {
		super("키보드로 이미지 움직이기");
		setSize(500,500);
		//setTitle("키보드로 이미지 움직이기");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.setLayout(null);
		label.setBounds(50, 50, 45, 45);
		//label.setOpaque(true);
		label.setBackground(Color.YELLOW);
		con.add(label);
		
		con.addKeyListener(new MyKeyAdapter());
		
		con.setFocusable(true);
		con.requestFocus();

		
	}
	
	class MyKeyAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("키눌림");
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			int x = label.getX();
			int y = label.getY();
			//System.out.println("x:" + x + "y:" + y);
			int maxX = con.getWidth() - label.getWidth();
			int maxY = con.getHeight() - label.getHeight();
			
			switch (keyCode) {
			case KeyEvent.VK_UP:
				
				y -= MOVE_UNIT;
				if(y < 0) {
					y=0;
				} 
				break;
			case KeyEvent.VK_DOWN:
				y += MOVE_UNIT;
				if(y > maxY) {
					y=maxY;					
				} 
				break;
			case KeyEvent.VK_RIGHT:
				label.setIcon(iconRight);
				x +=MOVE_UNIT;
				if (x > maxX) {
					x=maxX;
				}
				break;
			case KeyEvent.VK_LEFT:
				label.setIcon(iconLeft);
				x -= MOVE_UNIT;
				if (x < 0) {
					x=0;
				}
				
				break;
			}
			label.setLocation(x, y);
		}
		
	}

	public static void main(String[] args) {
		new FlyingImageEx();
	}

}
