package ex06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VibratingFrame extends JFrame implements Runnable {

	private Container con = getContentPane();
	private Thread th = new Thread(this);
	private Boolean isRun = true;
	private JButton button = new JButton("버튼");
	
	public VibratingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("진동하는 프레임");
		setSize(500,500);
		setLocation(700, 300);
		setVisible(true);
		con.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//th.interrupt(); //스레드 강제종료
				stopVibration();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				th = new Thread(VibratingFrame.this);
				isRun = true;
				th.start();
				
			}
		});
		con.setLayout(new FlowLayout());
		con.add(button);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new VibratingFrame();

	}
	
	public void stopVibration() {
		
		isRun = false;
	}
	
	public void run() {
		int MAX = 11;
		while (isRun) {
			int randomX = (int)(Math.random()*MAX)-5;
			int randomY = (int)(Math.random()*MAX)-5;
			int frameX = this.getX();
			int frameY = this.getY();
			this.setLocation(frameX + randomX, frameY + randomY);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
