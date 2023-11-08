package ex02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class MouseMotionListenerEX extends JFrame {
	
	Container con = getContentPane();
	JLabel lblHello = new JLabel("Hello");
	MyMouseMotionListener lis = new MyMouseMotionListener();
	
	
	public MouseMotionListenerEX() {
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("마우스 리스너 모션 예제");
			setSize(500,500);
			setVisible(true);
			con.setLayout(null);
			lblHello.setBounds(10, 10, 100, 30);
			con.add(lblHello);
			con.addMouseMotionListener(lis);
		
		
	}
	
	
	
	
	class MyMouseMotionListener 
	implements MouseMotionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("MousePressed");
			System.out.println("X:" + x + ", Y:" + y);
			lblHello.setLocation(x, y);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mouseMoved");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseMotionListenerEX();
	}

}
