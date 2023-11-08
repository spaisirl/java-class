package ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	
	int barSize = 200;		
	
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
	private MyPanel pnlThread = new MyPanel();
	
	JLabel lblCount = new JLabel("남은횟수:");
	JTextField tfCount = new JTextField("♥♥♥♥♥");
	
	private long startTime;
	
	private long endTime;
	
	public GuessNum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메세지 다이얼로그");
		setSize(500,500);
		con.setLayout(new BorderLayout());
		//Font f = new Font("맑은 고딕", Font.BOLD, 20);
		setListener();
		init();
		TabAndThreadEx();
		


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
	    JPanel southPanel = new JPanel(new GridLayout(1, 2));
	    // 왼쪽 셀에 pnlSouth 을 추가한다.
	    pnlSouth.setBackground(Color.CYAN);
	    pnlSouth.setLayout(new FlowLayout());
	    pnlSouth.add(lblCount);
	    pnlSouth.add(tfCount);
	    southPanel.add(pnlSouth);

	    // 오른쪽 셀에 pnlThread 을 추가한다.
	    
	    pnlThread.setBackground(Color.ORANGE);
	    pnlThread.setOpaque(true);
	    pnlThread.setBounds(50, 50, 100, 50);
	   

	    // 패널을 만들어서 pnlThread 를 둔다.
	    JPanel threadPanel = new JPanel(new GridLayout(1, 2));
	    threadPanel.add(pnlThread);

	    southPanel.add(threadPanel);

	    // UI에 Southpanel
	    con.add(southPanel, BorderLayout.SOUTH);
	    
	    con.setFocusable(true);
	    con.requestFocus();
	    
	    Thread th = new Thread(pnlThread);
		th.start();
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
	
	private void TabAndThreadEx() {
		
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
	
	
	
	
	public class MyPanel extends JPanel implements Runnable {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.fillRect(0, 0, barSize, 50);
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(this) {
				barSize--;
				System.out.println(barSize);
				repaint();
				if (barSize == 0) {
						try {
							System.out.println("before wait");
							wait();
							System.out.println("after wait");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			
		}
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
