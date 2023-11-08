package prac04;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SetIntervalEx extends JFrame {
	
	public  SetIntervalEx() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		SetInterval label = new SetInterval();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label, BorderLayout.CENTER);
		setSize(400,300);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new SetIntervalEx();
		
	}
	

}
