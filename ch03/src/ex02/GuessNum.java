package ex02;

import java.util.Scanner;

public class GuessNum {

	public static long startTime = 0L;
	public static int[] records = new int[5]; // {0,0,0,0,0,}
	public static final Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		//Scanner scanner = new Scanner(System.in);
		
		
		//int[] records = {30000,30000,30000,30000,30000};
		
		int count = 5;
		
		//System.out.println("===== 1 ~ 100 사이의 임의의 수를 맞춰 보세요 =====");
		//System.out.println("-----기회는 5번 입니다.-----");
		startTime = System.currentTimeMillis();
		//String yn;
		
		int targetNum = makeTargetNum();
		System.out.println("targetNum:" + targetNum);
		showRule();
		
		while(true) {
			System.out.println("for");
			int userNum = inputData();
			judge(targetNum, userNum);
			count--;
			if (count == 0) {
				break;
			}
			System.out.println("남은 기회는 "+count+"번입니다.");
		}
		
		System.out.println("기회를 모두 소진하였습니다.");
		
		
		
		initRecords();
		showRecords();
		
		again();
		
			
	
		/*while(true) {
			
			int rand = (int)(Math.random()*100)+1;
			System.out.println(rand);
			
			for(int i =0; i<=5; i++) {
				
				System.out.print("입력: ");
				int user = scanner.nextInt();	
				
			if (rand > user) {
				System.out.println(user + "보다 큽니다.");
				System.out.println("남은 기회는" + i + "번 입니다.");
			}
			else if (rand < user) {
				System.out.println(user + "보다 작습니다.");
				System.out.println("남은 기회는" + i + "번 입니다.");
			}
			else {
				System.out.println("정답입니다.");
				long endTime = System.currentTimeMillis();
				int time = (int)(endTime - startTime);
				System.out.println("time" + time);
				break;
				}
			}
			
			System.out.println("또 하시겠습니까? y/n");
			yn = scanner.next();
			if(yn.equals("y")) {
				continue;
			}
			else { 
				break;
			}
						
			
		}
		*/
			
								
			
					
		scanner.close();

	}
	
	public static void again() {
		
		String yn = "";
		System.out.println("또 하시겠습니까? y/n");
		yn = scanner.next();
//		if(yn.equals("y")) {
//			continue;
//		}
//		else { 
//			break;
//		}
		
	}
	
	
	
	//맞춰야 하는 숫자를 만든다.
	public static int makeTargetNum() {
		int targetNum = (int)(Math.random()*100)+1;
		return targetNum;
	}
	
	//숫자를 판단하는(맞추고 틀리고)
	public static void judge(int targetNum, int userNum) {
		
		
		if (targetNum == userNum) {
			System.out.println("정답");
			long endTime = System.currentTimeMillis();
			int time = (int)(endTime - startTime);
			System.out.println("time" + time);
			records[0] = time;
			showRecords();
		}
		else if (targetNum > userNum) {
			System.out.println(userNum + "보다 큽니다.");
			
		}
		else {
			System.out.println(userNum + "보다 작습니다.");
			
		}
		
		
	}
	
	
	public static int inputData() {
		System.out.print("입력: ");
		int num = scanner.nextInt();
		return num; //num은 inputData로 넘어간다.
	}
	
	
	// 시작 메시지(게임 규칙) 출력하기
	public static void showRule() {
		System.out.println("===== 1~100 사이의 임의의 수를 맞춰 보세요=====");
		System.out.println("기회는 5번 입니다.");
		
	}
	
	// 기록을 30000으로 초기화하기
	/**
	 * 
	 * @param records 점수 기록 배열
	 */
	public static void initRecords() {
		
		
		for (int i = 0;i<records.length;i++) {
			
			records[i] = 30000;
			//int aRecord[] = records.length;
		}
	}
	
	//기록 보여주기
	public static void showRecords() {
		for (int aRecord : records) {
			System.out.print(aRecord + " ");
			
		}
	}
	
	// 마지막으로 점수 갱신 시 새로운 큰 기록이 생겼을 시에 첫번째로
	// 오게 배열마다 비교해준다. [2]>[1]

}
