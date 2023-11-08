package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx2 extends JFrame {
	
	private Container con = getContentPane();
	private JLabel label = new JLabel("Hello");
	private static final int MOVE_UNIT = 10;
	
	public FlyingTextEx2() {
		super("키보드로 레이블 움직이기:레이블이 컨테이너 밖으로 벗어나지 못하도록 변경");
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
		
		//컨테이너 밖으로 벗어나지 못하도록 컨테이너 범위 설정
		// 레이블은 설정 된 컨테이너 범위 안에서 움직이도록 설정
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
			/* 내가 쓴 거
			switch (keyCode) {
			case KeyEvent.VK_UP:
				if(y > 0) {
					label.setLocation(x, y-MOVE_UNIT);
					break;
				} else {
					break;
				}		
			case KeyEvent.VK_DOWN:
				if(y < 440) {
					label.setLocation(x, y+MOVE_UNIT);
					break;
					
				} else {
					break;
				}
			case KeyEvent.VK_RIGHT:
				if (x < 440) {
					label.setLocation(x+MOVE_UNIT, y);
					break;
				}
			case KeyEvent.VK_LEFT:
				if (x > 0) {
					label.setLocation(x-MOVE_UNIT, y);
					break;
				}
				*/
			
			//강사님 방식
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
				x +=MOVE_UNIT;
				if (x > maxX) {
					x=maxX;
				}
				break;
			case KeyEvent.VK_LEFT:
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
		new FlyingTextEx2();
	}

}
