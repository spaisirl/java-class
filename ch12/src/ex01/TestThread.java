package ex01;

//파일명이랑 같은 것만 public 붙이기
public class TestThread {

	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		//th.run();
		th.start();
		
		int counter= 1000;
		while (counter <= 100000) {
			try {
				Thread.sleep(100);
				System.out.println(++counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("main 종료");
	}
}

//별도의 클래스
class TimerThread extends Thread {
	//스레드의 메인
	@Override
	public void run() {
		// dealy(millis)
		int counter= 0;
		while (counter <= 100) {
			try {
				Thread.sleep(100);
				System.out.println(++counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("run 종료");
	}
	
}