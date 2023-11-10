package Guess_Num2;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {
	
	private Container con = getContentPane();
	private RegisterDialog registerDialog = new RegisterDialog(this, "입력", true);
	
	private JLabel labelId = new JLabel("아이디");
	private JTextField tfId = new JTextField(5);	
	private JLabel labelPw = new JLabel("패스워드");
	private JPasswordField tfPw = new JPasswordField(5);
	private JButton btnlg = new JButton("로그인");
	private JButton btnadd = new JButton("사용자등록");
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setTitle("로그인");
		setListener();
		setUI();
		
		setVisible(true);
		
	}
	
	private void setListener() {
		btnlg.addActionListener(this);
		btnadd.addActionListener(this);
	}

	private void setUI() {
		
		con.setLayout(new GridLayout(3, 2));
		con.add(labelId);
		con.add(tfId);
		con.add(labelPw);
		con.add(tfPw);		
		con.add(btnlg);
		con.add(btnadd);
		
		
	}

	public static void main(String[] args) {
		new LoginFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//누구한테 발생했는지 알아내야 한다.
		Object obj = e.getSource();
		if (obj == btnadd) {
			registerDialog.setVisible(true);
		}
		
	}
	
	class RegisterDialog extends JDialog implements ActionListener {
		
		private JTextField tfId = new JTextField();
		private JPasswordField tfPw = new JPasswordField();
		private JPasswordField tfPwch = new JPasswordField();
		private JTextField tfName = new JTextField();
		private JTextField tfEmail = new JTextField();
		
		
		private JButton btnCheck = new JButton("완료");
		private JButton btnCancel = new JButton("취소");
		
		JTextField[] components = {
				tfId, tfPw, tfPwch, tfName, tfEmail	
		};
		
		/*
		 * JComponent 을 쓰지만 JTextField 도 가능해서 대체 
		JComponent[] components = {
				tfId, tfPw, tfPwch, tfName, tfEmail	
		};
		*/
		
		// 배열을 이용
		String[] texts = {
				"아이디",
				"패스워드",
				"패스워드 확인",
				"이름",
				"이메일"

		};
		
		public RegisterDialog (JFrame owner, String title, boolean ismodal) {
			
			super(owner, title, ismodal);
			this.setSize(500,500);
			this.setLayout(new GridLayout(6,2));
			this.setUI();
			
		}
		
		
		private void setUI() {
			for (int i = 0; i <texts.length; i++) {
				this.add(new JLabel(texts[i]));
				this.add(components[i]);
			}
			
			this.add(btnCheck);
			this.add(btnCancel);
			
			char[] chars = ((JPasswordField)tfPw).getPassword();
			String str = new String(chars);
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
