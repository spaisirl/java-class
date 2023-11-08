package ver14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame implements ActionListener {
	private static final String DELIM = " / ";
	private PhoneBook book = PhoneBook.getInstance();
	private Container con = getContentPane();
	private Vector<JMenuItem> vecItem = new Vector<>();
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");

	
	// North
//	private JTextField tfName = new JTextField(); // 이름
//	private JTextField tfPhoneNumber = new JTextField(); // 전화번호
//	private JTextField tfBirdthDay = new JTextField(); // 생일
//	private JRadioButton rdoSchool = new JRadioButton("학교", true);
//	private JRadioButton rdoCompany = new JRadioButton("회사");
//	private JTextField tfSchoolOrCompanyName = new JTextField();
	
	// Center
	private JTextArea taMessage = new JTextArea();
	
	// South
	private JTextField tfSearch = new JTextField(10);
	private JButton btnSearch = new JButton("찾기");
	private JButton btnInput = new JButton("입력");
	private JButton btnGetAll = new JButton("전체조회");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnExit = new JButton("종료");
	private JButton btnSave = new JButton("저장");
	
	private MyInputDialog myInputDialog = new MyInputDialog(this, "입력", true);
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("전화번화부 ver.12");
		setSize(500, 500);
		setUI();
		setListener();
		createMenu();
		
		setVisible(true);
	}

	private void setListener() {
		tfSearch.addActionListener(this);
		btnSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnGetAll.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		btnSave.addActionListener(this);
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
		chooser.setFileFilter(filter);
		
	}

	private void setSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(2, 1));
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(new JLabel("검색:"));
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		pnlSouth.add(pnlSearch);
		con.add(pnlSearch, BorderLayout.NORTH);
		
		JPanel pnlButton = new JPanel();
		pnlButton.add(btnInput);
		pnlButton.add(btnGetAll);
		pnlButton.add(btnUpdate);
		pnlButton.add(btnDelete);
		pnlButton.add(btnExit);
		pnlButton.add(btnSave);
		pnlSouth.add(pnlButton);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		taMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		
	}

	private void setNorth() {
//		JPanel pnlInput = new JPanel();
//		pnlInput.setLayout(new GridLayout(2, 4));
//		pnlInput.add(new JLabel("이름:"));
//		pnlInput.add(tfName);
//		pnlInput.add(new JLabel("전화번호:"));
//		pnlInput.add(tfPhoneNumber);
//		pnlInput.add(new JLabel("생일:"));
//		pnlInput.add(tfBirdthDay);
//		JPanel pnlSchoolOrCompany = new JPanel();
//		pnlSchoolOrCompany.add(rdoSchool);
//		pnlSchoolOrCompany.add(rdoCompany);
//		ButtonGroup group = new ButtonGroup();
//		group.add(rdoSchool);
//		group.add(rdoCompany);
//		pnlInput.add(pnlSchoolOrCompany);
//		pnlInput.add(tfSchoolOrCompanyName);
//		con.add(pnlInput, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new PhoneBookFrame();
	}
	
	private void printData(Vector<PhoneInfo> vector) {
		taMessage.setText("");
		for (PhoneInfo info : vector) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompanyName = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompanyName = ((PhoneInfoSchool)info).getSchool();
			} else {
				schoolOrCompanyName = ((PhoneInfoCompany)info).getCompany();
			}
			taMessage.append(name + DELIM);
			taMessage.append(phoneNumber + DELIM);
			taMessage.append(birthDay + DELIM);
			taMessage.append(schoolOrCompanyName + "\n");
		}
	}
	
//	private PhoneInfo makePhoneInfo() {
//		String name = tfName.getText();
//		String phoneNumber = tfPhoneNumber.getText();
//		String birthDay = tfBirdthDay.getText();
//		String schoolOrCompanyName = tfSchoolOrCompanyName.getText();
//		PhoneInfo info = null;
//		if (rdoSchool.isSelected()) {
//			info = new PhoneInfoSchool(name, phoneNumber, birthDay, schoolOrCompanyName);
//		} else {
//			info = new PhoneInfoCompany(name, phoneNumber, birthDay, schoolOrCompanyName);
//		}
//		return info;
//	}
	
	private boolean inputData(PhoneInfo info) {
		
		return book.addInfo(info);
	}
	
	private void createMenu() {
		// 메뉴바 - 프레임에 붙일
		JMenuBar menuBar = new JMenuBar();
		
		// 메뉴 - 메뉴바에 붙일
		JMenu mnuScreen = new JMenu("파일");
		
		
		//메뉴바에 메뉴들 붙이기
		menuBar.add(mnuScreen);	
		
		//Screen 메뉴에 붙일 아이템들
		JMenuItem miInput = new JMenuItem("입력");
		miInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				myInputDialog.setVisible(true);
				System.out.println("다이얼로그 열림");
				
			}
			
		});
		
		JMenuItem miLoad = new JMenuItem("불려오기");
		miLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(miLoad);
				if (result != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "선택하지 않으셨습니다.", "입력", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				File selectedFile = chooser.getSelectedFile();
				String path = selectedFile.getPath();
				System.out.println("path:" + path);
				book.setLoad(path);

			}
		});
		
		JMenuItem miSave = new JMenuItem("저장");
		miSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showSaveDialog(miSave);
				if (result != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "선택하지 않으셨습니다.", "입력", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				File selectedFile = chooser.getSelectedFile();
				String path = selectedFile.getPath();
				System.out.println("path:" + path);
				book.setSave(path);

			}
		});
		
		JMenuItem miHide = new JMenuItem("전체조회");
		JMenuItem miReshow = new JMenuItem("수정");
		JMenuItem miDelete = new JMenuItem("삭제");
		JMenuItem miExit = new JMenuItem("종료");
		miExit.addActionListener(this);
		vecItem.add(miInput);
		vecItem.add(miLoad);
		vecItem.add(miSave);
		vecItem.add(miHide);
		vecItem.add(miReshow);
		vecItem.add(miDelete);
		vecItem.add(miExit);
		
		
		// Screen 메뉴에 아이템 달기
		mnuScreen.add(miInput);
		mnuScreen.add(miLoad);
		mnuScreen.add(miSave);
		mnuScreen.add(miHide);
		mnuScreen.add(miReshow);
		mnuScreen.add(miDelete);
		mnuScreen.addSeparator(); //분리선
		mnuScreen.add(miExit);
		
		
		//프레임에 메뉴바 붙이기
		setJMenuBar(menuBar);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
//		if (obj == tfSearch || obj == btnSearch) {
//			String name = tfName.getText();
//			PhoneInfo info = book.searchByName(name);
//			if (info == null) {
//				taMessage.append("\n" + name + "님의 정보가 없습니다.");
//			} else {
//				printData(info);
//				taMessage.append("\n---- 검색 완료 ----");
//			}
//		} else if (obj == btnInput) {
		if (obj == btnInput) {
			myInputDialog.setVisible(true);
		
		} else if (obj == btnGetAll) {
			Vector<PhoneInfo> vector = book.getAll();
			if (vector == null || vector.size() == 0) {
				taMessage.setText("---- 데이터가 없습니다. ----");
			} else {
				printData(vector);
			}
		} else if (obj == btnUpdate) {
			String name = JOptionPane.showInputDialog(PhoneBookFrame.this, 
					"이름을 입력하세요", "입력", 
					JOptionPane.OK_CANCEL_OPTION);
			// System.out.println("PhoneBookFrame, actionPorformed, name:" + name);
			if (name != null && !name.equals("")) {
				myInputDialog.setInputOrUpdate("수정");
				PhoneInfo info = book.searchByName(name);
				if (info == null) {
					// 옵션팬 보이기
					return;
				}
				myInputDialog.setInfo(info);
				myInputDialog.setVisible(true);
			}
			// myInputDialog.setVisible(true);
		
//			PhoneInfo info = makePhoneInfo();
//			boolean result = book.modify(info);
//			if (result) {
//				taMessage.append("\n" + info.getName() + "의 정보가 수정되었습니다.");
//			} else {
//				taMessage.append("\n" + info.getName() + "의 정보가 없습니다.");
//			}
		} 
//		else if (obj == btnDelete) {
//			String name = tfName.getText();
//			boolean result = book.delete(name);
//			if (result) {
//				taMessage.append("\n" + name + "의 정보를 삭제했습니다.");
//			} else {
//				taMessage.append("\n" + name + "의 정보가 없습니다.");
//			}
//		} 
//		else if (obj == btnExit) {
//			System.exit(0);
//		}
		else if (obj == btnSave) {
			book.save();
		}

	}
	
	
	class MyInputDialog extends JDialog implements ActionListener {
		private JTextField tfName = new JTextField(); // 이름
		private JTextField tfPhoneNumber = new JTextField(); // 전화번호
		private JTextField tfBirdthDay = new JTextField(); // 생일
		private JRadioButton rdoSchool = new JRadioButton("학교", true);
		private JRadioButton rdoCompany = new JRadioButton("회사");
		private JTextField tfSchoolOrCompanyName = new JTextField();
		private JButton btnFinish = new JButton("입력완료");
		private JButton btnCancel = new JButton("취소");
		
		public MyInputDialog(JFrame owner, String title, boolean modal) {
			super(owner, title, modal);
			this.setSize(300, 200);
			this.setLayout(new GridLayout(5, 2, 10, 10));
			this.add(new JLabel("이름:"));
			this.add(this.tfName);
			this.add(new JLabel("전번:"));
			this.add(this.tfPhoneNumber);
			this.add(new JLabel("생일"));
			this.add(this.tfBirdthDay);
			JPanel panel = new JPanel();
			ButtonGroup group = new ButtonGroup();
			panel.add(this.rdoSchool);
			panel.add(this.rdoCompany);
			group.add(rdoSchool);
			group.add(rdoCompany);
			this.add(panel);
			this.add(this.tfSchoolOrCompanyName);
			this.add(this.btnFinish);
			this.add(this.btnCancel);
			this.btnFinish.addActionListener(this);
			this.btnCancel.addActionListener(this);
		}
		
		public void setInputOrUpdate(String title) {
			setTitle(title);
			btnFinish.setText(title + "완료");
		}
		
		public void setInfo(PhoneInfo info) {
			String name = info.getName();
			String phoneNumber = info.getPhoneNumber();
			String birthDay = info.getBirthDay();
			String schoolOrCompany = "";
			if (info instanceof PhoneInfoSchool) {
				schoolOrCompany = ((PhoneInfoSchool)info).getSchool();
				rdoSchool.setSelected(true);
			} else if (info instanceof PhoneInfoCompany) {
				schoolOrCompany = ((PhoneInfoCompany)info).getCompany();
				rdoCompany.setSelected(true);
			}
			tfName.setText(name);
			tfPhoneNumber.setText(phoneNumber);
			tfBirdthDay.setText(birthDay);
			tfSchoolOrCompanyName.setText(schoolOrCompany);
		}
		
		private PhoneInfo makePhoneInfo() {
			String name = this.tfName.getText();
			String phoneNumber = this.tfPhoneNumber.getText();
			String birthDay = this.tfBirdthDay.getText();
			String schoolOrCompanyName = this.tfSchoolOrCompanyName.getText();
			PhoneInfo info = null;
			if (this.rdoSchool.isSelected()) {
				info = new PhoneInfoSchool(name, phoneNumber, birthDay, schoolOrCompanyName);
			} else {
				info = new PhoneInfoCompany(name, phoneNumber, birthDay, schoolOrCompanyName);
			}
			return info;
		}
		
		private void showMessage(String message) {
			JOptionPane.showMessageDialog(PhoneBookFrame.this, message, "알림", JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btnFinish) {
				PhoneInfo info = this.makePhoneInfo();
				System.out.println(info);
				boolean result = book.addInfo(info);
				if (result) {
					showMessage("데이터 입력 완료");
				} else {
					showMessage("데이터 입력 실패");
				}
			} else if (obj == btnCancel) {
				// this.setVisible(false);
			}
			this.setVisible(false);
		}
		
	}
	
}
