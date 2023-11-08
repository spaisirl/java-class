package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {


	private static final long serialVersionUID = 1L;
	
	Container c = getContentPane();
	//배치관리자 : BorderLayout
	String[] texts = {"add", "sub", "div", "Calculate"};
	String[] positions = {
			BorderLayout.EAST,
			BorderLayout.WEST,
			BorderLayout.SOUTH,
			BorderLayout.NORTH,
			BorderLayout.CENTER
	};
	
	

	public BorderLayoutEx()  {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BorderLayout 예제");
		c.setLayout(new BorderLayout(20, 20));
		
		//창 띄우기
		setVisible(true);
		
		//창 크기
		setSize(300,300);
		
		
		/*버튼 만들기
		c.add(button1);
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		*/
		
		for (int i = 0; i < texts.length; i++) {
			c.add(new JButton(texts[i]), positions[i]);
		}
		
		//배경색 지정
		c.setBackground(Color.BLUE);
		
		
		
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}
