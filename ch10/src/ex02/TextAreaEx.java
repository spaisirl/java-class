package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextAreaEx extends JFrame {
	private Container con = getContentPane();
	
	public TextAreaEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("텍스트 에어리어 예제");
		
		JTextArea taHello = new JTextArea("Hello",10,30);
		taHello.setEditable(false);
		con.setLayout(new FlowLayout());
		con.add(new JScrollPane(taHello));
		
		JTextField tf = new JTextField(30);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				taHello.append(text + "\n");
				
			}
		});
		
		con.add(tf);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextAreaEx();

	}

}
