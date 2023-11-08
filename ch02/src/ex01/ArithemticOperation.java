package ex01;

import java.util.Scanner;

public class ArithemticOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자입력: ");
		int num = scan.nextInt();
		
		//2의 배수라면
		if (num%2 == 0) {
			System.out.println("짝수입니다.");
		} 
		else {
			System.out.println("홀수입니다.");
		}
		
		//3의 배수이거나 5의배수라면
		
		if (num%3 ==0 || num%5 ==0 ) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		scan.close();

	}

}
