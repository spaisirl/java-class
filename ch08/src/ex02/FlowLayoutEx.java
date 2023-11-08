package ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame {


	private static final long serialVersionUID = 1L;
	
	Container c = getContentPane();
	//배치관리자 : BorderLayout
	String[] texts = {"add", "sub", "div", "Calculate"};

	public FlowLayoutEx()  {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("예제");
		
		//창 띄우기
		setVisible(true);
		
		//창 크기
		setSize(300,300);
		
		
		//버튼 간격
		c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		
		/*버튼 만들기
		c.add(button1);
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		*/
		
		for (int i = 0; i < texts.length; i++) {
			c.add(new JButton(texts[i]));
		}
		
		//배경색 지정
		c.setBackground(Color.BLUE);
		
		
		
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx();
	}

}
