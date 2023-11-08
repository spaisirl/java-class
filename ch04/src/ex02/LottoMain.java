package ex02;

public class LottoMain {

	//과제 ex02, ex03
	public static void main(String[] args) { //main() - 프로그램 컨트롤(제어)
		// 1~10번까지는 노란색,
		// 11~20번 파란색
		// 21~30번 빨간색
		// 31~40번 회색
		// 41~45번 녹색
		
		//LottoBall aBall = new LottoBall(1,"yellow");
		//aBall.showInfo();
		
		
		
		//공 45개 넣기
		LottoBall[] balls = new LottoBall[45];
		//System.out.println(balls[0]);
		
		//
		for(int i = 0; i<balls.length; i++) {
			String color = "";
			if(0 <= i && i <10) {
				color = "yellow";
			}
			else if(10 <= i && i <20) {
				color = "Blue";
			}
			else if(20 <= i && i <30) {
				color = "Red";
			}
			else if(30 <= i && i <40) {
				color = "Grey";
			}
			else if (40 <= i && i <balls.length)  {
				color = "Green";
			}
			balls[i] = new LottoBall(i+1, color);
		}
		
		// 섞기 - 0번째 <-임의의 위치 -> 스와핑
		for (int i = 0; i<balls.length * 2; i++) {
			int rand = (int)(Math.random()*44)+1; //1~44번째
			LottoBall tempBall = balls[0];
			balls[0] = balls[rand];
			balls[rand] = tempBall;
		}
		
		/*
		for (LottoBall ball : balls) {
			ball.showInfo();
		} 
		*/
		
		for (int i = 0; i <6 ; i++) {
			balls[i].showInfo();
		}
	}

}
