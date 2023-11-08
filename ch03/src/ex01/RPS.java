package ex01;

import java.util.Scanner;

public class RPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int winScore = 0;
		
		for (int i = 1; i <= 5; i++) {
		
			System.out.print("입력(1.가위 2.바위 3.보): ");
			int user = scanner.nextInt();
			
			//1~3까지 com 변수 저장
			int com = (int)(Math.random()*3)+1;
			System.out.println(com);
			
			String result = "";
			
			switch (user) {
				case 1:
					switch(com) {
						case 1:
							result = "비김";
							winScore += 1;
							break; // case1
						case 2:
							result = "짐";
							winScore += 0;
							break; // case2
						case 3:
							result= "이김";
							winScore += 3;
							break; // case3
					
					} // switch (com)	
					break; //case1
				case 2:
					switch(com) {
					case 1:
						result = "이김";
						winScore += 3;
						break; // case1
					case 2:
						result = "비김";
						winScore += 1;
						break; // case2
					case 3:
						result = "짐";
						winScore += 0;
						break; // case3
				
				} // switch (com)
					break; //case2
				case 3:
					switch(com) {
					case 1:
						result = "짐";
						winScore += 0;
						break; // case1
					case 2:
						result = "이김";
						winScore += 3;
						break; // case2
					case 3:
						result = "비김";
						winScore += 1;
						break; // case3
						
					} // switch (com)
					break; //case3
			} //switch (user)
			
			System.out.println(result);
			System.out.println("승점: " + winScore);
		}
		scanner.close();
	}

}
