package ex02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseListenerEx extends JFrame {
	
	MyMouseListener lis = new MyMouseListener();
	Container con = getContentPane();
	JLabel lblHello = new JLabel("Hello");

	public MouseListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(500,500);
		setVisible(true);
		con.setLayout(null);
		lblHello.setBounds(10,10,10,10);
		lblHello.setSize(50,20);
		con.add(lblHello);
		con.addMouseListener(lis);
		
	}
	
	//내부클래스
	private class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("MousePressed");
			System.out.println("X:" + x + ", Y:" + y);
			lblHello.setLocation(x, y);
		}

		@Override
		public void mouseReleased(MouseEvent e) { //눌려진 마우스 버튼이 떼어질 때
			System.out.println("mouseReleased");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerEx();
	}

}
