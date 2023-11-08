package prac01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MousePractice extends JFrame {
	
	Container con = getContentPane();
	JLabel label = new JLabel("자기야");
	MyMouseListener lis = new MyMouseListener(); 
	
	public MousePractice() {
		setSize(500, 500);
		setTitle("연습문제1");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		con.add(label);
		con.addMouseListener(lis);
		con.addMouseMotionListener(lis);
		label.addMouseListener(lis);
		con.setBackground(Color.GREEN);

	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("click");
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			con.setBackground(Color.GREEN);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == label) {
			label.setText("사랑해");
			}
			
		}

		@Override
		public void mouseExited(MouseEvent e) {	
				label.setText("자기야");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			con.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MousePractice();
	}


}

