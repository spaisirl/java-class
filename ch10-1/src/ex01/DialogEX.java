package ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DialogEX extends JFrame{
	
	MyDialog dialog = new MyDialog();
	private Container con = getContentPane();
	private JButton button = new JButton("클릭");
	public DialogEX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다이얼로그 예제");
		setSize(300,300);
		setVisible(true);
		con.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialog.setVisible(true);
				
			}
		});
	}
	
	class MyDialog extends JDialog {
		private JTextField txtName = new JTextField(10);
		private JButton btnOk = new JButton("OK");
		public MyDialog() {
			this.setTitle("마이 다이얼로그");
			this.setSize(300,200);
			// 다이얼로그의 기본 배치관리자 - 보더 레이아웃
			this.setLayout(new FlowLayout());
			this.add(txtName);
			this.add(btnOk);
			btnOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = txtName.getText();
					button.setText(name);
					//MyDialog.this.dispose();
					MyDialog.this.setVisible(false);
					
				}
			});
		}
	}
	public static void main(String[] args) {
		new DialogEX();

	}

}
