package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JComponentEx extends JFrame {

	private Container con = getContentPane();
	JButton button1 = new JButton("Margenta/Yellow Button");
	JButton button2 = new JButton("Disable Button");
	JButton button3 = new JButton("getX(), getY()");
	
	public JComponentEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("컴포넌트 공통 기능");
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		con.add(pnl);
		
		button1.setForeground(Color.MAGENTA);
		button1.setBackground(Color.YELLOW);
		Font f = new Font("맑은 고딕", Font.ITALIC, 50);
		button1.setFont(f);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button2.setEnabled(true);
				
			}
		});
		
		button2.setEnabled(false);
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = button3.getX();
				int y = button3.getY();
				setTitle(x+ "," + y);
				
			}
		});
		
		pnl.add(button1);
		pnl.add(button2);
		pnl.add(button3);
		setSize(500, 500);
		setVisible(true);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComponentEx();
	}

}
