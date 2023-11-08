package ex03;

import java.util.Scanner;

public class Prac08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("커피를 주문하세요>>");
		String menu = scanner.next();
		int num1 = scanner.nextInt(); 
		  
		
		switch(menu) {
		case"아메리카노":
			System.out.print("잔 입니다. "+(2500*num1) + "원 입니다.");
			break;
		case"카푸치노":
			System.out.println((3000*num1) + "원 입니다.");
			break;
		case"에스프레소":
			System.out.println((2000*num1) + "원 입니다.");
			break;
		case"카페라떼":
			System.out.println((3500*num1) + "원 입니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		
		scanner.close();
		
		
		
	}

}
