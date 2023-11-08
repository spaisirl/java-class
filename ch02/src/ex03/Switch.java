package ex03;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* switch else~
			if와 다른 점은 break 존재.
			점수 입력 값처럼 범위에 대한 값이면 if
			특정 값에는 switch
		*/
		Scanner scanner = new Scanner(System.in); // 실제 객체명은 scanner 타입명 Scanner
		
		System.out.print("월(1~12)을 입력하세요: ");
		int month = scanner.nextInt();
		
		switch(month) {
		case 3:
		case 4:
		case 5:
		System.out.println("봄입니다.");
		break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
		
		scanner.close();
		
	}

}
