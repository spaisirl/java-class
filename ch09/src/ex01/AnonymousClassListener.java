package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AnonymousClassListener extends JFrame {
	private Container con = getContentPane();
	private JButton btnAction = new JButton("Action");
	
	public AnonymousClassListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("익명 클래스로 리스너 만들기");
		setSize(500,200);
		con.setLayout(new FlowLayout());
		con.add(btnAction);
		//btnAction.addActionListener(new HisActionListener());
		btnAction.addActionListener(new ActionListener() {
			
			@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println("클릭");
					// Action <-> 액션
					Object obj = e.getSource();
					JButton theButton = (JButton)obj;
					String text = theButton.getText(); // 글자를 얻어 온다.
					System.out.println(text);
					if (text.equals("Action")) {
						theButton.setText("액션");
					} else {
						theButton.setText("Action");
					}

			}
		}); //adddAcitonListener
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnonymousClassListener();
	}
} // class

