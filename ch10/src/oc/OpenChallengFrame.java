package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenChallengFrame extends JFrame implements ItemListener {
	private Container con = getContentPane();
	int index = 0;
	MenuPanel menuPanel = new MenuPanel();
	
	//버튼 불려오지 못한 거: con.add(menupanel, BoderLayout.SOUTH) 를 생각하지 못함
	// 이미지 나타내기 : 배열이 필요한 거는 인지했지만 어떤 식으로 사용해야 할지 떠오르지 못함
	
	/*
	 * 배열을 이용하여 이미지 나타내기
	private ImageIcon[] images = {
			new ImageIcon("images/image0.jpg"),
			new ImageIcon("images/image1.jpg"),
			new ImageIcon("images/image2.jpg"),
			new ImageIcon("images/image3.jpg"),
			
	};
	*/
	
	//배열을 이용하여 이미지 나타내기
	private ImageIcon[] images = new ImageIcon[4];
	
	//private JLabel label = new JLabel(new ImageIcon("images/left.png"));
	
	private JLabel label = new JLabel(new ImageIcon("images/image0.jpg"));
	
	/* 이미지가 4개라서 JLabel 도 4가지가 필요할 줄 알았지만 아니였다.
	private JLabel label1 = new JLabel(new ImageIcon("images/image0.jpg"));
	private JLabel label2 = new JLabel(new ImageIcon("images/image1.jpg"));
	private JLabel label3 = new JLabel(new ImageIcon("images/image2.jpg"));
	private JLabel label4 = new JLabel(new ImageIcon("images/image3.jpg"));
	*/
	
	public OpenChallengFrame() {
		setTitle("간단 이미지 뷰어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.setLayout(new BorderLayout());
		setImages();
		
		
		

		
		setSize(300, 400);
		con.add(menuPanel, BorderLayout.SOUTH);
		con.add(label, BorderLayout.CENTER);
		setVisible(true);
	}
	


	private void setImages() {
		
		for (int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon("images/image"+i+".jpg");
		}
		
	}



	public class MenuPanel extends JPanel implements ActionListener {
		
		JButton btnLeft = new JButton(new ImageIcon("images/left.png"));
		JButton btnRight = new JButton(new ImageIcon("images/right.png"));
		
		public MenuPanel() {
			
			add(btnLeft);
			add(btnRight);
			setBackground(Color.DARK_GRAY);
			
			btnLeft.addActionListener(this);
			btnRight.addActionListener(this);
			
		}

		// 버튼을 누를 때 사진 넘기기
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj == btnLeft) {
				index--;
				if (index < 0) {
					index = images.length - 1 ;
				} 
			} else if (obj == btnRight) {
				index++;
				if (index > images.length - 1) {
					index = 0 ;
				} 
				
			}
			
			label.setIcon(images[index]);
		}
		
	}




	public static void main(String[] args) {
		new OpenChallengFrame();

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
