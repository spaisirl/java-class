package ex02;

public class scoreAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores = {
				{100, 90, 80},
				{90, 80, 70},
				{80, 70, 60},
				{70, 60, 50}
					
		};
		System.out.println(scores[0][0]);
		System.out.println(scores[2][2]);
		
		int total =0;
		for (int i =0; i< scores.length;i++) {
			for(int k = 0; k< scores[i].length;k++) {
				total += scores[i][k];
			}
		}
		
		/*
		for (int i=0; i <scores[1].length;i++) {
			total += scores[1][i];
		}
		*/
		
		
		System.out.println("tatal: " +total);
		
		int totalLength = 0;
		
		for (int i=0; i <scores.length;i++) {
			totalLength += scores[i].length;
		}
		
		System.out.println("average: " + ((double)total
				/ totalLength));
	}
	
		

}
