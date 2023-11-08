package ex03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ListenerFrameEx extends JFrame 
	implements ActionListener {
	
	private Container con = getContentPane();
	private JButton button = new JButton("Click");
	
	public ListenerFrameEx() {
		setSize(500,500);
		setVisible(true);
		setTitle("프레임 리스너 제거");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컨테이너에 버튼 달기
		con.add(button);
		//버튼에 액션리스너 달기
		button.addActionListener(this); 
		// addActionListener를 구현 받은 건 ListenerFrameEx 라서 자기 자신을 받을 수 있다.

	}
	
	public static void main(String[] args) {
		new ListenerFrameEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭");
	}

}
