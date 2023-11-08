package ex01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class OneToTenFrame extends JFrame {

	Container con = getContentPane(); 
	MyActionListener lis = new MyActionListener();
	JButton[] buttons = new JButton[10];

	public OneToTenFrame() {
		
		
		
		//창크기
		this.setSize(500, 500);
		
		//타이틀
		this.setTitle("재배치");
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.setLayout(null);
		
		
		//랜덤한 숫자 박스 만들기
		for(int i = 0; i < 10; i++) {
			JButton button = new JButton(String.valueOf(i+1));
			button.setSize(50, 50);
			int x = (int)(Math.random()*(484-50));
			int y = (int)(Math.random()*(461-50));
			button.setLocation(x, y);
			button.addActionListener(lis); // 익명 클래스로 만드는 거
			con.add(button);
			buttons[i] = button;
			
		}
		
		//창나타내기
		this.setVisible(true);
		
		int w = con.getWidth();
		int h = con.getHeight();
		System.out.println("w:" + w + ", h:" + h);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		new OneToTenFrame();
	}
	
	class MyActionListener implements ActionListener {
		// 이벤트 처리를 위한 인터페이스는 Listenr와 Adapter 두 가지이며, 전자는 이벤트 메소드를
		// 전부 오버라이딩하여 사용하고, 후자는 필요한 것만 사용한다.
		int nextNumber = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			// 1이면 안 보이게
			Object obj = e.getSource();
			JButton theButton = (JButton)obj;
			String text = theButton.getText();
			if(text.equals(String.valueOf(nextNumber))) {
				theButton.setVisible(false);
				nextNumber++;
				if (nextNumber > 10) {
				restart();
				}	
				
			}	
			
		}
		
		private void restart() {
			for (int i =0; i< buttons.length; i++) {
				int x = (int)(Math.random()*(484-50));
				int y = (int)(Math.random()*(461-50));
				buttons[i].setLocation(x, y);
				buttons[i].setVisible(true);
			}
			nextNumber = 1;
		}
		
	}
	

}
