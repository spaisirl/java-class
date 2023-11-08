package prac04;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;

@SuppressWarnings("serial")
//스레드 기능이 있는 레이블
public class SetInterval extends JLabel implements Runnable { //Runnable 을 쓰면 별도의 스레드에서 실행 가능
	
	private Calendar c; // 시, 분, 초 변수를 만든다.
	private int hour;
	private int min;
	private int second;
	
	public SetInterval() {
		setFont(new Font("맑은 고딕", Font.BOLD, 50));
		Thread th = new Thread(this); //run을 본인이 가지고 있어서 객체를 쓰지 않고 this을 이용한다.
		th.start();
	}
	public static void main(String[] args) {
		new SetInterval();
		
	}

	@Override
	public void run() { // implements Runnable 을 쓰게 하면 오버라이딩 run 이 따라온다.
		
		while (true) {
			c = Calendar.getInstance();
			hour = c.get(Calendar.HOUR_OF_DAY);
			min = c.get(Calendar.MINUTE);
			second = c.get(Calendar.SECOND);
			
			/*
			String clockText = Integer.toString(hour); // 변수에 값을 넣어주기 때문에 toString 을 이용한다.
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			setText(clockText);
			*/
			
			try {
				StringBuffer sb = new StringBuffer();
				sb.append(hour);
				sb.append(":");
				sb.append(min);
				sb.append(":");
				sb.append(second);
				
				this.setText(sb.toString());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		
	}

}


