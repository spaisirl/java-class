package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NullLayoutEx extends JFrame {
	
	Container con = getContentPane();
	
	//패널
	JPanel pnlL = new JPanel();
	JPanel pnlR = new JPanel();
	
	public NullLayoutEx() {
		
		
		//JFrame에 상속 받는 거
		//창닫기 버튼
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//창제목
		this.setTitle("NullLayoutex");
		//창크기
		this.setSize(500, 500);
		
		//UI설정
		setUI();
		
		//창보이기
		this.setVisible(true);
		
	}
	
	private void setUI() {
		// 컨테이너의 배치관리자 설정 - 그리드 레이아웃 (1*2)
		con.setLayout(new GridLayout(1,2,10,10));
		setLeft();
		setRight();
		//컨테이너 패널 달기
		con.add(pnlL);
		con.add(pnlR);
	}
	
	private void setLeft() {
		// 왼쪽 패널의 배치관리자 설정 -  플로우 레이아웃
		pnlL.setLayout(new FlowLayout());
		// 왼쪽 패널을 오렌지 색으로 변경
		pnlL.setBackground(Color.ORANGE);
		//버튼 두개 달기 
		pnlL.add(new JButton("확인"));
		pnlL.add(new JButton("취소"));
		
	}
	
	private void setRight() {
		// 오른쪽 패널의 배치관리자 설정 - 배치관리자를 삭제
		pnlR.setLayout(null);

		// 오른쪽 패널을 녹색으로 변경
		pnlR.setBackground(Color.GREEN);
		
		//버튼을 10개 달기
		//패널에 배치관리자가 없다 -> 버튼들의 크기와 위치 설정
		for (int i = 1; i <=10 ; i++) {
			JButton button = new JButton(String.valueOf(i));
			/*
			//크기
			button.setSize(100,50);
			//위치
			button.setLocation(i*20, i*20);
			*/
			//크기, 위치
			button.setBounds(i*20, i*20, 100, 50);
			//패널에 버튼 달기
			pnlR.add(button);
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new NullLayoutEx();

	}

}
