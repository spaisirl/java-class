package ex03;

public class LottoMachine {
	// LottoMachine has as LottoBall
	public LottoBall[] balls = new LottoBall[45];

	public void setBalls() {
		for (int i = 0; i < balls.length; i++) {
			String color = "";
			if (0 <= i && i < 10) {
				color = "yellow";
			} else if (10 <= i && i < 20) {
				color = "Blue";
			} else if (20 <= i && i < 30) {
				color = "Red";
			} else if (30 <= i && i < 40) {
				color = "Grey";
			} else if (40 <= i && i < balls.length) {
				color = "Green";
			}
			balls[i] = new LottoBall(i + 1, color);
		}

	} // setBalls()

	public void shuffle() {
		// 섞기 - 0번째 <-임의의 위치 -> 스와핑
		for (int i = 0; i < balls.length * 2; i++) {
			int rand = (int) (Math.random() * 44) + 1; // 1~44번째
			LottoBall tempBall = balls[0];
			balls[0] = balls[rand];
			balls[rand] = tempBall;
		}
	}

	public void show6balls() {
		for (int i = 0; i < 6; i++) {
			balls[i].showInfo();
		}
	}

	public void showAllBalls() {
		for (LottoBall ball : balls) {
			ball.showInfo();
		}
	}

}
