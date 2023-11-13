package Guess_Num2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GuessNumFrame extends JFrame implements ActionListener {
	private static final int MIN_SCORE = 30000; 
	private GameManager manager = GameManager.getInstance();
	private ScoreDao scoreDao = ScoreDao.getInstance();
	
	private MyDialog dialog = new MyDialog(this, "다이얼로그", true);
	
	private static final String START_MESSAGE 
		= "1~100 사이의 임의의 숫자를 맞춰보세요\n-----기회는 5번입니다.-----";
	private Container con = getContentPane();
	// North
	private JPanel pnlNorth = new JPanel();
	private JTextField tfInput = new JTextField(5);
	private JButton btnInput = new JButton("입력");
	private JLabel lblRecord = new JLabel("기록:");
	private JTextField tfRecord = new JTextField("300000");
	private JButton btnRecord = new JButton("기록보기");
	private JButton btnNewGame = new JButton("새게임");
	
	// Center
	private JTextArea taMessage = new JTextArea(START_MESSAGE);
	
	// South
	private JPanel pnlSouth = new JPanel();
	private JLabel lblCount = new JLabel("남은횟수:");
	private JTextField tfCount = new JTextField(7);
	
	private long startTime;
	private long endTime;
	
	private UserVo loginVo;
	
	public GuessNumFrame(UserVo userVo) {
		this.loginVo = userVo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자맞추기 - " + loginVo.getUserId() + "(" + loginVo.getUserName() + ")");
		setSize(700, 500);
		setUI();
		setListener();
		setVisible(true);
		init();
	}
	
	private void exitOneGame() {
		tfInput.setEnabled(false);
		btnInput.setEnabled(false);
	}

	private void setListener() {
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnNewGame.addActionListener(this);
		
		/*
		btnRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				System.out.println("다이얼로그 열림");
				
			}
		});
		*/
		
		
	}

	private void setUI() {
		setNorth();
		setCenter();
		setSouth();
	}

	private void setSouth() {
		pnlSouth.setBackground(Color.CYAN);
		pnlSouth.add(lblCount);
		pnlSouth.add(tfCount);
		con.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setCenter() {
		con.add(new JScrollPane(taMessage), BorderLayout.CENTER);
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	}

	private void setNorth() {
		pnlNorth.setBackground(Color.YELLOW);
		pnlNorth.add(tfInput);
		pnlNorth.add(btnInput);
		pnlNorth.add(lblRecord);
		int minScore = scoreDao.getMinScore();
		System.out.println("minScore:" + minScore);
		tfRecord.setText(String.valueOf(minScore));
		pnlNorth.add(tfRecord);
		pnlNorth.add(btnRecord);
		pnlNorth.add(btnNewGame);
		con.add(pnlNorth, BorderLayout.NORTH);
	}
	
	private void init() {
		manager.init();
		tfInput.setEnabled(true);
		btnInput.setEnabled(true);
		tfRecord.setEditable(false);
		taMessage.setEditable(false);
		tfCount.setEditable(false);
		taMessage.setText(START_MESSAGE);
		printHeart();
		startTime = System.currentTimeMillis();
	}

//	public static void main(String[] args) {
//		new GuessNumFrame();
//	}
	
	private void printHeart() {
		int count = manager.getCount();
		String heart = "";
		for (int i = 0; i < count; i++) {
			heart += "♥";
		}
		tfCount.setText(heart);
	}
	
	private void updateRecord() {
		System.out.println("updateRecord");
		long score = endTime - startTime;
		if (score > MIN_SCORE) {
			return;
		}
//		String username = JOptionPane.showInputDialog(this, "이름을 입력하세요");
//		ScoreVo scoreVo = new ScoreVo(username, (int)score);
		ScoreVo scoreVo = new ScoreVo();
		scoreVo.setUserId(loginVo.getUserId());
		scoreVo.setScore((int)score);
		boolean result  = scoreDao.addScore(scoreVo);
		System.out.println("result:" + result);
		//데이터 입력 완료 메세지
		String strRecord = tfRecord.getText();
		long lRecord = Long.parseLong(strRecord);
		if (score < lRecord) {
			tfRecord.setText(String.valueOf(score));
		}
	}

	private void appendMessage(int result, int userNum) {
		String resultMessage = "";
		switch (result) {
			case GameManager.RESULT_OK:
				resultMessage = "----- 정답입니다. -----";
				exitOneGame();
				endTime = System.currentTimeMillis();
				updateRecord();
				break;
			case GameManager.RESULT_BIG:
				resultMessage = "----- " + userNum + " 보다 큽니다. -----";
				break;
			case GameManager.RESULT_SMALL:
				resultMessage = "----- " + userNum + " 보다 작습니다. -----";
				break;
		} // switch
		// System.out.println(resultMessage);
		taMessage.append("\n" + resultMessage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfInput || obj == btnInput) {
			String userInput = tfInput.getText();
			try {
				int userNum = Integer.parseInt(userInput);
				// 범위 체크
				if (1 > userNum || userNum > 100) {
					// taMessage.append("\n1~100 사이의 숫자를 입력해주세요.");
					JOptionPane.showMessageDialog(
							GuessNumFrame.this, "1~100 사이의 숫자를 입력해주세요.", 
							"알림", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int result = manager.judge(userNum);
				appendMessage(result, userNum);
			} catch (NumberFormatException nfe) {
				// taMessage.append("\n숫자만 입력해주세요.");
				JOptionPane.showMessageDialog(
						GuessNumFrame.this, "숫자만 입력해 주세요", 
						"알림", JOptionPane.ERROR_MESSAGE);
				tfInput.setText("");
				return;
			}
			
			int count = manager.getCount();
			if (count == 0) {
				taMessage.append("\n기회를 모두 소진하였습니다.");
				exitOneGame();
			}
			printHeart();
			tfInput.setText("");
		} else if (obj == btnNewGame) {
			init();
		} else if (obj == btnRecord) {
			dialog.setVisible(true);
		}
		
	}
	
	class MyDialog extends JDialog {

	
		public MyDialog(JFrame owner, String title, boolean isModal) {
			super(owner, title, isModal);
			this.setSize(200,200);
			this.setLayout(new FlowLayout());
			this.add(new JLabel("이름"));
			
			
		}
		
		
	}

}