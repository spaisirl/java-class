package ex08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class WaitNotifyEX extends JFrame {
	private Container con = getContentPane();
	private MyLabel label = new MyLabel("0");
	private JButton button = new JButton("버튼");
	
	public WaitNotifyEX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("잠자기와 깨우기");
		setSize(500,500);
		con.add(button, BorderLayout.NORTH);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized(label) {
					label.notify();
				}
			}
		});
		setVisible(true);
		Thread th = new Thread(label);
		th.start();
	}
	
	
		
		class MyLabel extends JLabel implements Runnable {
			
			public MyLabel(String value) {
				super(value);
			}
			
			@Override
			public void run() {
				
				while (true) {
				String text = label.getText();
				int number = Integer.parseInt(text);
				number++;
				label.setText(String.valueOf(number));
					try {
					Thread.sleep(100);
					} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
					}
					if (number % 10 == 0) {
						try {
							synchronized (this) {
								wait();
								
							}
						}	catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
		}
	
		public static void main(String[] args) {
			new WaitNotifyEX();

		}

	}
