package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx extends JFrame {
	
	private Container con = getContentPane();
	private JLabel label = new JLabel("Enter키로 배경색이 바뀝니다.");
	
	
	public KeyListenerEx() {
		setSize(500,500);
		setTitle("키 리스너 예제");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(new FlowLayout());
		con.add(label);
		// 레이블 기본상태 - 투명한 상태 -> 불투명한 상태로 만들어야 색상 적용 됨
		label.setOpaque(true);
		label.setBackground(Color.YELLOW);
		con.addKeyListener(new MyKeyAdapter());
		//키이벤트를 받을 조건
		con.setFocusable(true);
		con.requestFocus();
	}
	
	class MyKeyAdapter extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("문자 키 타이핑");
			char ch = e.getKeyChar(); //객체가 아니라서 ch. 찍을 수 없다.
			if (ch == '\n') {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Color newColor = new Color(r, g, b); // rgb(red green blue)
				con.setBackground(newColor);
				label.setText("red = "+ r + ", green= "+ g + ", blue=" + b);
			} else if (ch == 'q') {
				System.exit(0);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("키보드 눌림");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("키보드 뗌");
		}
		
	}
	
	
	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
