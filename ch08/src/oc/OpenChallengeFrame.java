package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengeFrame extends JFrame {
	
	Container con = getContentPane();
	
	public OpenChallengeFrame() {
		
		con.setLayout(new BorderLayout(1,10));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("오픈 챌린지");
		
		this.setSize(500, 500);
		
		setUI();
		
		setVisible(true);
	
		
	}
	
	private void setUI() {
		setNorth();
		setSouth();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OpenChallengeFrame();

	}

	private void setSouth() {
		con.add(new SouthPanel(), BorderLayout.CENTER);
	}
	
	private void setNorth() {
		con.add(new NorthPanel(), BorderLayout.NORTH);
	}
	
}




	@SuppressWarnings("serial")
	class NorthPanel extends JPanel {
		String[] texts = {"Opne", "Read", "Close"};
		
		public NorthPanel() {
			
			setBackground(Color.GRAY);
			for(int i = 0; i < texts.length; i ++) {
				add(new JButton(texts[i]));
			}
			}
		}
	
	
	@SuppressWarnings("serial")
	class SouthPanel extends JPanel {
		
		public SouthPanel() {
		this.setLayout(null);
		JButton button = new JButton();
	
		this.add(button);
		this.setBackground(Color.LIGHT_GRAY);
		JLabel lblHello = new JLabel("Hello Java");
		lblHello.setBounds(200, 200, 100, 30);
		add(lblHello);
			
		
		}
	
	
	}

