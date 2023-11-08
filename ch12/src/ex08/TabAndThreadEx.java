package ex08;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TabAndThreadEx extends JFrame{
	private Container con = getContentPane();
	private MyLabel label = new MyLabel();
	int barSize = 200;
	
	public TabAndThreadEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("탭 앤 스레드");
		setSize(500,200);
		setVisible(true);
		con.setLayout(null);
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setBounds(50, 50, 400, 50);
		con.add(label);
		con.setFocusable(true);
		con.requestFocus();
		/*
		con.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyReleased(KeyEvent e) {
			synchronized(label) {
				if (barSize == 400) {
					return;
				}
				barSize++;
				label.repaint();
				label.notify();
			}
		}
		});
		*/
		
		Thread th = new Thread(label);
		th.start();
		
		
	}
	public static void main(String[] args) {
		new TabAndThreadEx();

		
	}
	public class MyLabel extends JLabel implements Runnable {
		//int barSize = 200;
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.fillRect(0, 0, barSize, 50);
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(this) {
				barSize--;
				System.out.println(barSize);
				repaint();
				if (barSize == 0) {
						try {
							System.out.println("before wait");
							wait();
							System.out.println("after wait");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			
		}
	}

}
