package Guess_Num2;


public class TestMain {
	
	private static ScoreDao scoreDao = ScoreDao.getInstance();
	public static void main(String[] args) {
		for (int i = 0; i <=100; i++) {
			ScoreVo scoreVo = new ScoreVo(null, "hong", 15000 + i, null);
			scoreDao.addScore(scoreVo);
		}
		
	}
}
