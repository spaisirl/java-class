package ex03;

import java.util.Scanner;

public class Prac10 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("커피 주문하세요>>");
		System.out.print("커피: ");
		System.out.print("갯수: ");
		String menu = scanner.next();
		int num = scanner.nextInt();
		
		switch(menu) 
		{
		case "에스프레소":
			if(num>=10) {
				System.out.println((int)((2000*num*(1-0.05))) + "원 입니다.");
			}
			else {
				System.out.println((2000*num) + "원 입니다.");
			}
			break;
		case "아메리카노":
			System.out.println((2500*num) + "원 입니다.");
			break;
		case "카푸치노":
				System.out.println((3000*num) + "원 입니다.");
			break;
		case "카페라떼":
				System.out.println((3500*num)+ "원 입니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
			break;
		}
	
		scanner.close();
	}
	
}
