package Guess_Num2;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {
	
	
	private Container con = getContentPane();
	private JTextField tfId = new JTextField();
	private JPasswordField pfPw = new JPasswordField();
	private JButton btnLogin = new JButton("로그인");
	private JButton btnRegister = new JButton("사용자등록");
	
	private RegisterDialog registerDialog = new RegisterDialog(this, "사용자등록", true);
	
	private UserDao userDao = UserDao.getInstance();
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setTitle("로그인");
		
		setUI();
		
		setVisible(true);
		
	}
	

	private void setUI() {
		
		con.setLayout(new GridLayout(3, 2));
		con.add(new JLabel("아이디"));
		con.add(tfId);
		con.add(new JLabel("패스워드"));
		con.add(pfPw);
		con.add(btnLogin);
		con.add(btnRegister);
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		new LoginFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//누구한테 발생했는지 알아내야 한다.
		Object obj = e.getSource();
		if (obj == btnRegister) {
			registerDialog.setVisible(true);
		}
		
		//로그인 버튼
		
		else if (obj == btnLogin) {
			String userId = tfId.getText();
			String userPw = new String(pfPw.getPassword());
			LoginDto loginDto = new LoginDto(userId, userPw);
			UserVo userVo = userDao.login(loginDto);
			if (userVo == null) {
				JOptionPane.showMessageDialog(null, "알림", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				
				JOptionPane.showMessageDialog(null, "알림", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				new GuessNumFrame(userVo);
				this.dispose(); // 창 없애기
			}
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
			
			add(btnCheck);
			add(btnCancel);
			
			btnCheck.addActionListener(this);
			btnCancel.addActionListener(this);
			
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btnCheck) {
				String userId = tfId.getText();
				char[] chars = tfPw.getPassword();
				String userPw = new String(chars);
				// String userPw = new String(tfPw.getPassword()); 쓰는 거 가능
				String userName = tfName.getText();
				String userEmail = tfEmail.getText();
				
				//setters 이용
				UserVo userVo = new UserVo(userId, userPw, userName, userEmail);
				System.out.println("userVo:" + userVo.toString());
				
				boolean result = userDao.addUser(userVo); 
				System.out.println("add result: " + result);
				if (result) {
					JOptionPane.showMessageDialog(null, "사용자 등록 완료하였습니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, "사용자 등록 실패.", "실패", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}else if (obj == btnCancel) {
				this.setVisible(false);
			}
		}
		
	
		
	}
	
}
