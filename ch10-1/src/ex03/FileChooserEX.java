package ex03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileChooserEX extends JFrame{
	
	private Container con = getContentPane();
	private JLabel lblImage = new JLabel();
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & GIF", "jpg", "png", "gif");
	
	public FileChooserEX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("파일 다이얼로그 예제");
		setSize(500,500);
		setMenu();
		con.add(lblImage);
		
		setVisible(true);
	}
	private void setMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miOpen = new JMenuItem("Open");
		miOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null); // 모달 다이얼로그 형태
				System.out.println("다이얼로그 닫힘:" + result);
				if (result != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				System.out.println("파일을 선택했습니다.");
				File selectedFile = chooser.getSelectedFile();
				String path = selectedFile.getPath();
				System.out.println("path:" + path); //FileChooser 역할
				ImageIcon icon = new ImageIcon(path);
				lblImage.setIcon(icon); // 기본 borderlayout 상태에서 이미지를 나타나게 한다.
				pack(); //JFrame 이미지 크기에 맞춰서 나온다.
			}
		});
		mnuFile.add(miOpen);
		menubar.add(mnuFile);
		setJMenuBar(menubar);
		
	}
	public static void main(String[] args) {
		new FileChooserEX();

	}

}
