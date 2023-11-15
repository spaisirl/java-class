package Guess_Num3;

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
	private UserDao userDao = UserDao.getInstance();
	private Container con = getContentPane();
	private JTextField tfId = new JTextField("hong");
	private JPasswordField pfPw = new JPasswordField("1234");
	private JButton btnLogin = new JButton("로그인");
	private JButton btnRegister = new JButton("사용자등록");
	
	private RegisterDialog registerDialog = new RegisterDialog(this, "사용자등록", true);
	
	public LoginFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("로그인");
		this.setSize(300, 150);
		this.setUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
		Object obj = e.getSource();
		// 사용자 등록 버튼
		if (obj == btnRegister) {
			registerDialog.setVisible(true);
		}
		// 로그인 버튼
		else if (obj == btnLogin) {
			String userId = tfId.getText();
			String userPw = new String(pfPw.getPassword());
			LoginDto loginDto = new LoginDto(userId, userPw);
			UserVo userVo = userDao.login(loginDto);
			// 로그인 실패
			if (userVo == null) {
				JOptionPane.showMessageDialog(null, "로그인 실패", "알림", JOptionPane.ERROR_MESSAGE);
			} 
			// 로그인 성공
			else {
				JOptionPane.showMessageDialog(null, "로그인 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
				new GuessNumFrame(userVo);
				this.dispose(); // 창 없애기
			}
		}
		
	}
	
	class RegisterDialog extends JDialog implements ActionListener {
		String[] texts = {
				"아이디",
				"패스워드",
				"패스워드 확인",
				"이름",
				"이메일",
		};
		
		JTextField tfId = new JTextField();
		JPasswordField pfPw = new JPasswordField();
		JPasswordField pfPw2 = new JPasswordField();
		JTextField tfName = new JTextField();
		JTextField tfEmail = new JTextField();
		JTextField[] components = {
				tfId, pfPw, pfPw2, tfName, tfEmail
		};
		JButton btnOk = new JButton("완료");
		JButton btnCancel = new JButton("취소");
		public RegisterDialog(JFrame owner, String title, boolean isModal) {
			super(owner, title, isModal);
			this.setSize(300, 200);
			this.setLayout(new GridLayout(6, 2));
			this.setUI();
		}
		
		private void setUI() {
			for (int i = 0; i < texts.length; i++) {
				add(new JLabel(texts[i]));
				add(components[i]);
			}
			add(btnOk);
			add(btnCancel);
			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btnOk) {
				String userId = tfId.getText();
				char[] chars = pfPw.getPassword();
				String userPw = new String(chars);
				String userName = tfName.getText();
				String userEmail = tfEmail.getText();
				// setters 이용
				/*
				UserVo userVo = new UserVo();
				userVo.setUserId(userId);
				userVo.setUserPw(userPw);
				userVo.setUserName(userName);
				userVo.setUserEmail(userEmail);
				*/
				UserVo userVo = new UserVo(userId, userPw, userName, userEmail);
				System.out.println("userVo:" + userVo.toString());
				System.out.println("userVo:" + userVo);
				boolean result = userDao.addUser(userVo);
				System.out.println("add result: " + result);
				if (result) {
					JOptionPane.showMessageDialog(null, "사용자 등록 완료", 
							"완료", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "사용자 등록 실패", 
							"실패", JOptionPane.ERROR_MESSAGE);
				}
			} else if (obj == btnCancel) {
				this.setVisible(false);
			}
			
		}
	}

}
