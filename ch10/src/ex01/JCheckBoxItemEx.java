package ex01;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class JCheckBoxItemEx extends JFrame implements ItemListener {
	private String[] names = {"사과", "배", "체리"};
	private int[] prices = {100, 500, 20000};
	private Container con = getContentPane();
	private JPanel pnlMenu = new JPanel();
	private JPanel pnlResult = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JLabel lblMenu = new JLabel();
	private JLabel lblResult = new JLabel("현재 0원 입니다.");
	private JCheckBox[] checks = new JCheckBox[names.length]; // {null, null, null}
	// 체크박스가 들어 갈 공간을 만든 것 , {null, null, null} 뿐인 공간
	
	public JCheckBoxItemEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("아이템 이벤트 예제");
		setSize(500,200);
		String menuText = makeMenuText();
		lblMenu.setText(menuText);
		makeMenuText();
		makeCheckBoxes();		
		setUI();
		setListener();
		setVisible(true);
		
	}
	
	
	//체크 박스 버튼 만들기
	private void setListener() {
		for (int i = 0; i < checks.length; i++) {
			checks[i].addItemListener(this);
		}
	}
	
	
	
	//체크 박스 공간 만들기
	private void makeCheckBoxes() {
			for (int i = 0; i < checks.length; i++) {
				checks[i] = new JCheckBox(names[i]);
			}
		
	}
	
	
	// 가격을 알려주는 창
	private String makeMenuText() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < names.length; i++) {
			sb.append(names[i] + " " + prices[i] + "원");
			if (i != names.length-1) {
				sb.append(", ");
			}
		}
		String text = sb.toString();
		return text;
	}

	private void setUI() {
	
		//메뉴판 (판넬)
		//con.add(new JLabel("사과 100원, 배 500원, 체리 20000원"), BorderLayout.NORTH);
		
		//North
		pnlMenu.setBackground(Color.YELLOW);
		pnlMenu.add(lblMenu);
		con.add(pnlMenu, BorderLayout.NORTH);
		//Center
		for (int i = 0; i < checks.length; i++) {
			pnlCenter.add(checks[i]);
		}

		con.add(pnlCenter, BorderLayout.CENTER);
		//South
		pnlResult.setBackground(Color.CYAN);
		pnlResult.add(lblResult);
		con.add(pnlResult, BorderLayout.SOUTH);
		
	}
	
	
	public static void main(String[] args) {
		new JCheckBoxItemEx();
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		int sum = 0;
		for (int i = 0; i < checks.length; i++) {
			if(checks[i].isSelected()) {
				sum += prices[i];
			}
		}
		// System.out.println("sum: " + sum);
		lblResult.setText("현재 " + sum + "원 입니다.");
		
	}
	
	
	

}
