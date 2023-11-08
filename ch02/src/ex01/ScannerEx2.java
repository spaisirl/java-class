package ex01;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("숫자1: ");
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		System.out.print("숫자2: ");
		int num2 = scan.nextInt();
		/*int total = num1 + num2;
		System.out.print("결과: " + num1 + "+" + num2 + "=" + total);
		*/
		System.out.print("결과: " + num1 + "+" + num2 + "=" + (num1+num2)); 
		//위에는 교수님이 하신 거
		//코드가 떠오르지 않을 때, 할 수 있는 것부터 써보기
		scan.close();

	}

}
