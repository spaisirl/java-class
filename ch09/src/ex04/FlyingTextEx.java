package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx extends JFrame {
	
	private Container con = getContentPane();
	private JLabel label = new JLabel("Hello");
	private static final int MOVE_UNIT = 10;
	
	public FlyingTextEx() {
		super("키보드로 레이블 움직이기");
		setSize(500,500);
		//setTitle("키보드로 레이블 움직이기");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.setLayout(null);
		label.setBounds(50, 50, 30, 15);
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
			switch (keyCode) {
			case KeyEvent.VK_UP:
				label.setLocation(x, y-MOVE_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				label.setLocation(x, y+MOVE_UNIT);
				break;
			case KeyEvent.VK_RIGHT:
				label.setLocation(x+MOVE_UNIT, y);
				break;
			case KeyEvent.VK_LEFT:
				label.setLocation(x-MOVE_UNIT, y);
				break;
			}
		}
		
		
	}

	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
