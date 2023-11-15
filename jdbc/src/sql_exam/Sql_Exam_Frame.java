package sql_exam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Sql_Exam_Frame extends JFrame implements ActionListener {
	private static final String DELIM = " | ";
	private Sql_Exam_Dao dao = Sql_Exam_Dao.getInstance();
	private Container con = getContentPane();

	// Center
	private JTextArea taMessage = new JTextArea();
	
	// South
	private JTextField tfSearch = new JTextField(10);
	private JButton btnInput = new JButton("입력");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JButton btnGetAll = new JButton("조회");
	
	
	String[] columnNames = {"SNO", "SNAME", "SCORE", "SYEAR", "MAJOR", "GENDER"};
	JComboBox<String> combo = new JComboBox<String>(new String[] {
			"학번", "이름", "점수", "학년", "전공" , "성별"
	});
	
	private MyInputDialog myInputDialog = new MyInputDialog(this, "입력", true);
	
	public Sql_Exam_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
	}



	private void setListener() {
		tfSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnGetAll.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);

	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setSouth() {

	}

	private void setCenter() {
		taMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		
	}

	
	private void setNorth() {
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(btnInput);
		pnlNorth.add(btnGetAll);
		pnlNorth.add(btnUpdate);
		pnlNorth.add(btnDelete);
		con.add(pnlNorth, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new Sql_Exam_Frame();
	}
	

	private void printData(Vector<Sql_Exam_Vo> vector) {
		taMessage.setText("");
		for (Sql_Exam_Vo info : vector) {
			String sno = info.getSno();
			String sname = info.getSname();
			Integer score = info.getScore();
			Integer syear = info.getSyear();
			Integer major = info.getMajor();
			String gender =  info.getGender();
			
			taMessage.append(sno + DELIM);
			taMessage.append(sname + DELIM);
			taMessage.append(score + DELIM);
			taMessage.append(syear + DELIM);
			taMessage.append(major + DELIM);
			taMessage.append(gender + "\n");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		System.out.println(obj);
		
		
		if (obj == btnInput) {
			myInputDialog.setVisible(true);
		
		} else if (obj == btnGetAll) {
//			Vector<PhoneInfo> vector = book.getAll();
//			Vector<Sql_Exam_Vo> vector = dao.getAll();
//			if (vector == null || vector.size() == 0) {
//				taMessage.setText("---- 데이터가 없습니다. ----");
//			} else {
//				printData(vector);
//			}
		} else if (obj == btnUpdate) {
//			String name = JOptionPane.showInputDialog(Sql_Exam_Frame.this, 
//					"이름을 입력하세요", "입력", 
//					JOptionPane.OK_CANCEL_OPTION);
//			if (name != null && !name.equals("")) {
//				myInputDialog.setInputOrUpdate("수정");
//				Sql_Exam_Vo info = new Sql_Exam_Vo();
//				Sql_Exam_Vo info = dao.addInfo(null);
//				if (info == null) {
//					JOptionPane.showMessageDialog(null, "데이터 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//				myInputDialog.setInfo(info);
//				myInputDialog.setVisible(true);
//			}
		} else if (obj == btnDelete) {
//			String name = JOptionPane.showInputDialog(null, "이름을 입력하세요");
//			boolean result = book.delete(name);
//			if (result) {
//				taMessage.append("\n" + name + "의 정보를 삭제했습니다.");
//			} else {
//				taMessage.append("\n" + name + "의 정보가 없습니다.");
//			}
		} 
		
	}
	
	class MyInputDialog extends JDialog implements ActionListener {
		private JTextField tfSno = new JTextField(); // 학번
		private JTextField tfSname = new JTextField(); // 이름
		private JTextField tfScore = new JTextField(); // 점수
//		private JTextField tfGrade = new JTextField(); // 학년
//		private JTextField tfMajor = new JTextField(); // 전공
		private JRadioButton rdoMan = new JRadioButton("남자", true);
		private JRadioButton rdoFemale = new JRadioButton("여자");
		private JButton btnFinish = new JButton("입력완료");
		private JButton btnCancel = new JButton("취소");
		String [] list = {"경영", "화학", "컴퓨터공학", "피아노"};
		Integer [] classList = {1, 2, 3, 4};
		JComboBox<Integer> cbGrade = new JComboBox<Integer>(classList); // 학년
		JComboBox<String> cbMajor = new JComboBox<String>(list); // 전공
		
		public MyInputDialog(JFrame owner, String title, boolean modal) {
			super(owner, title, modal);
			this.setSize(300, 300);
			this.setLayout(new GridLayout(7, 2, 10, 10));
			this.add(new JLabel("학번"));
			this.add(this.tfSno);
			this.add(new JLabel("이름"));
			this.add(this.tfSname);
			this.add(new JLabel("점수"));
			this.add(this.tfScore);
			this.add(new JLabel("학년"));
			this.add(cbGrade);
			this.add(new JLabel("전공"));
			this.add(cbMajor);
			this.add(new JLabel("성별"));
			JPanel panel = new JPanel();
			ButtonGroup group = new ButtonGroup();
			panel.add(this.rdoMan);
			panel.add(this.rdoFemale);
			group.add(rdoMan);
			group.add(rdoFemale);
			this.add(panel);
			this.add(this.btnFinish);
			this.add(this.btnCancel);
			//this.add(this.tfManOrFemaleName);
			this.btnFinish.addActionListener(this);
			this.btnCancel.addActionListener(this);
		}
		
		public void setInputOrUpdate(String title) {
			setTitle(title);
			if (title.equals("입력")) {
				tfSname.setEditable(true);
			} else if (title.equals("수정")) {
				tfSname.setEditable(false);
			}
			btnFinish.setText(title + "완료");
		}
		
		public void setInfo(Sql_Exam_Vo info) {
			String sno = info.getSno();
			String sname = info.getSname();
			Integer syear = info.getSyear();
			Integer major = info.getMajor();
			Integer score = info.getScore();
			String gender = info.getGender();
			if (gender.equals("M")) {
				rdoMan.setSelected(true);
			} else {
				rdoFemale.setSelected(true);
			}
			
			tfSno.setText(sno);
			tfSname.setText(sname);
		}
		
		private Sql_Exam_Vo makeInfo() {
			String sno = this.tfSno.getText();
			String sname = this.tfSname.getText();
			Integer syear = (Integer)cbGrade.getSelectedItem();
			System.out.println("syear: " + syear);
			Integer score = Integer.parseInt(this.tfScore.getText());
			String major = (String)cbMajor.getSelectedItem();
			
			/*
			 * sql decode를 이용하여 숫자로 받게 한다.
			int mno = 0;
			if (major.equals("경영")) {
				mno = 1;
			} else if(major.equals("화학") {
				mno = 2;
			} else if(major.equals("컴퓨터 공학") {
				mno = 3;
			}  else if(major.equals("피아노")   {
				mno = 4;
			}
			*/
			
			System.out.println("major: " + major);
			String gender = null;
			Sql_Exam_Vo info = null;
			if (this.rdoMan.isSelected()) {
				gender = "M";
			} else {
				gender= "F";
			}
//			info = new Sql_Exam_Vo(sno, sname, syear, gender, major, score);
			return info;
		}
		
		private void showMessage(String message) {
			JOptionPane.showMessageDialog(Sql_Exam_Frame.this, message, "알림", JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String title = getTitle();
			
			if (obj == btnFinish) {
				boolean result = false;
				if (title.equals("입력")) {
					Sql_Exam_Vo info = this.makeInfo();
					System.out.println(info);
					result = dao.addInfo(info);
					System.out.println("입력 result:" + result);
				} else if (title.equals("수정")) {
//					Sql_Exam_Vo info = this.makeInfo();
//					System.out.println(info);
//					result = book.modify(info);
				}
				
				if (result) {
					showMessage("데이터 " + title + " 완료");
				} else {
					showMessage("데이터 " + title + " 실패");
				}
				
			} else if (obj == btnCancel) {
				 this.setVisible(false);
			}
			this.setVisible(false);
		}
	}
}
