package ex01;

import java.util.Scanner;

public class ScannerEX {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //여기서 scan은 객체
		//작업들 (사용자로부터 키보드 입력을 받아서 뭔가를 한다)
		String str = scan.next();
		System.out.println("str: " + str);
		
		int num = scan.nextInt();
		System.out.println("num: " + num);
		
		double d = scan.nextDouble();
		System.out.println("d: " + d);
		
		String data = scan.nextLine();
		System.out.println("data: " + data); //엔터키 전까지
		
		scan.close();
		System.out.println("--프로그램 종료--");
	}

}
