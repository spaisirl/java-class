package ex04;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RunnableLabelEx extends JFrame {
	private Container con = getContentPane();
	private MyLabel label = new MyLabel("0");
	private MyLabel label2 = new MyLabel("100");
	
	public RunnableLabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(300,300);
		label.setFont(new Font("맑은 고딕",Font.BOLD ,50));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setFont(new Font("맑은 고딕",Font.BOLD ,50));
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		con.setLayout(new GridLayout(1,2));
		con.add(label);
		con.add(label2);
		Thread th = new Thread(label);
		th.start();
		Thread th2 = new Thread(label2);
		th2.start();
		setVisible(true);
	}
	
	// 스레드 기능이 있는 레이블
	public class MyLabel extends JLabel implements Runnable {
		public MyLabel(String value) {
			super(value);
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Thread.sleep(1000);
					String text = getText();
					int number = Integer.parseInt(text);
					number++;
					String strNumber = String.valueOf(number);
					setText(strNumber);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new RunnableLabelEx();
	}
}
