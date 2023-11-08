package ex03;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RunnableTimerEX extends JFrame {
	
	private Container con = getContentPane();
	private JLabel label = new JLabel("100");
	
	public RunnableTimerEX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("러너블을 이용한 타이머 레이블");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		setSize(300,300);
		con.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Thread th = new Thread(new TimerRunnable(label));
		th.start();
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new RunnableTimerEX();

	}

}
