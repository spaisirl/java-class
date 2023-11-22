package ex02;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LamdaFrame extends JFrame {
	
	private Container con = getContentPane();
	private JButton button = new JButton("버튼");

	public LamdaFrame() {
		
	}
	
	public static void main(String[] args) {
		new LamdaFrame();

	}

}
