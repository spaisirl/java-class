package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessNum extends JFrame implements ActionListener {
	private Container con = getContentPane();
	private GuessNumManager manager = GuessNumManager.getInstance();
			
	//north
	JPanel pnlNorth = new JPanel();
	JLabel lblInput = new JLabel("입력:");
	JTextField tfInput = new JTextField(5);
	JButton btnInput = new JButton("입력");
	JLabel lblRecord = new JLabel("기록:");
	JTextField tfRecord = new JTextField("30000");
	JButton btnNewGame = new JButton("새게임");
	
	
	//center
	JTextArea taMessage = new JTextArea("1~100까지의 숫자를 맞춰보세요.");
	JPanel pnlCenter = new JPanel();
	
	
	//south
	JPanel pnlSouth = new JPanel();
	JLabel lblCount = new JLabel("남은횟수:");
	JTextField tfCount = new JTextField("♥♥♥♥♥");
	
	private long startTime;
	
	private long endTime;
	
	public GuessNum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메세지 다이얼로그");
		setSize(500,500);
		//Font f = new Font("맑은 고딕", Font.BOLD, 20);
		setListener();
		init();
		setUI();
		
		setVisible(true);
	}
	
	


	private void printHeart() {
		int count = manager.getCount();
		String heart = "";
		
		for (int i = 0; i < count; i++) {
			heart += "♥";
		}
		tfCount.setText(heart);
	}


	private void setListener() {
		
		tfInput.addActionListener(this);
		btnInput.addActionListener(this);
		btnNewGame.addActionListener(this);
		
		
		/*
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				System.out.println("입력버튼을 눌렸습니다.");
			}
		});
		
		
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.out.println("새게임을 클릭했습니다.");
			}
			
			
		});
		
		tfInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				
				taMessage.append("\n" + t.getText());
				t.setText("");
			}
	
			
		});
		
		*/
		
	}

	
	
	private void setUI() {
		north();
		center();
		south();
		
		
	}

	private void north() {

		
		pnlNorth.setBackground(Color.MAGENTA);
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		pnlNorth.add(btnInput);
		pnlNorth.add(lblRecord);
		pnlNorth.add(tfRecord);
		pnlNorth.add(btnNewGame);
		con.add(pnlNorth, BorderLayout.NORTH);

		
	}
	
	private void center() {
		taMessage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		con.add(new JScrollPane(taMessage));
		
	}

	private void south() {
		pnlSouth.setBackground(Color.CYAN);
		pnlSouth.add(lblCount);
		pnlSouth.add(tfCount);
		con.add(pnlSouth,BorderLayout.SOUTH);
	}
	
	private void init() {
		
		manager.init();
		
		tfInput.setEditable(true);
		btnInput.setEnabled(true);
		tfRecord.setEnabled(false);
		taMessage.setEnabled(false);
		tfCount.setEnabled(false);
		
		taMessage.setText("1~100까지의 숫자를 맞춰보세요.");
		
		printHeart();
		
		startTime = System.currentTimeMillis();
		
	}


	public static void main(String[] args) {
		new GuessNum();
	}

	
	private void appendMessage(int result, int userNum) {

		String resultMessage = "";
		switch (result) {
		
		case GuessNumManager.RESULT_OK:
			resultMessage = "정답입니다.";
			
			exitOneGame();
			
			endTime = System.currentTimeMillis();
			
			updateRecord();
			
			break;
		case GuessNumManager.RESULT_BIG:
			resultMessage = userNum + "보다 큽니다.";
			break;
		case GuessNumManager.RESULT_SAMLL:
			resultMessage = userNum + "보다 작습니다.";
			break;
		
		}

		taMessage.append("\n"+resultMessage);
	}
	

	private void updateRecord() {
		
		long timetaken = endTime - startTime;
		
		String strRecord = tfRecord.getText();
		long lRecord = Long.parseLong(strRecord);
		
		if (timetaken < lRecord) {
			tfRecord.setText(String.valueOf(timetaken));
		}
		
	}


	private void exitOneGame() {
		tfInput.setEditable(false);
		btnInput.setEnabled(false);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfInput || obj == btnInput) {
			String userInput = tfInput.getText();
			try {
				int userNum = Integer.parseInt(userInput);
				
				if (1 > userNum || userNum > 100) {
					JOptionPane.showMessageDialog(GuessNum.this, "1~100 사이의 숫자를 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int result = manager.judge(userNum);
				appendMessage(result, userNum);
				
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(GuessNum.this, "숫자만 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
				tfInput.setText("");
				return;
			}
			
			int count = manager.getCount();
			
			if (count == 0) {
				taMessage.append("\n기회를 모두 소진하였습니다.");
				JOptionPane.showMessageDialog(GuessNum.this, "기회를 모두 소진하였습니다.", "알림", JOptionPane.ERROR_MESSAGE);
				
				exitOneGame();
			}
			
			printHeart();
			
			tfInput.setText("");
			
		} else if (obj == btnNewGame) {
			init();
		}
		
	}
}
