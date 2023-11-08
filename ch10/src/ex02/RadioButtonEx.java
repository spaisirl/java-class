package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener {
	
	private Container con = getContentPane();
	
	public RadioButtonEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("라디오 버튼 예제");
		setSize(500,500);
		
		//체크박스 생성
		JRadioButton rdoApple = new JRadioButton("사과");
		JRadioButton rdoPear = new JRadioButton("배", true);
		JRadioButton rdoCherry = new JRadioButton("체리");
		
		con.setLayout(new FlowLayout());
		con.add(rdoApple);
		con.add(rdoPear);
		con.add(rdoCherry);
		
		//체크박스에 이미지 넣기
		JRadioButton rdoPhone = new JRadioButton("전화", new ImageIcon("images/normalIcon.gif"));
		rdoPhone.setSelectedIcon(new ImageIcon("images/pressedIcon.gif"));
		con.add(rdoPhone);
		
		//버튼그룹 (여러개 중에서 하나만 선택 가능하게 구현)
		ButtonGroup group = new ButtonGroup();
		group.add(rdoApple);
		group.add(rdoPear);
		group.add(rdoCherry);
		
		
		//프레임
		rdoApple.addItemListener(this);
		rdoPear.addItemListener(this);
		rdoCherry.addItemListener(this);
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// item : 체크박스, 라디오 박스를 말하는 것
		System.out.println(e);
		int state = e.getStateChange();
		if (state == ItemEvent.SELECTED) {
			Object obj = e.getItem();
			String text = ((JRadioButton)obj).getText(); //다운캐스팅 했다. obj는 텍스트를 불려올 수 없기 때문.
			System.out.println(text + "이(가) 선택되었어요.");
		}
	}

}
