package ex02;

import java.util.Scanner;

//객체지향적 프로그래밍
public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MyCalculator calculator = new MyCalculator();
		
		System.out.println("*** 간단계산기 ***");
		System.out.print("숫자1: ");
		calculator.x= scanner.nextInt();
		System.out.print("숫자2: ");
		calculator.y= scanner.nextInt();
		System.out.println("덧셈: " + 
				calculator.x + "+" 
				+ calculator.y + "=" 
				+ calculator.add());
		System.out.println("뺄셈: " + 
				calculator.x + "-" 
				+ calculator.y + "=" 
				+ calculator.sub());
		System.out.println("곱하기: " + 
				calculator.x + "*" 
				+ calculator.y + "=" 
				+ calculator.mul());
		System.out.println("나누기: " + 
				calculator.x + "/" 
				+ calculator.y + "=" 
				+ calculator.div());
		System.out.println("나머지: " + 
				calculator.x + "%" 
				+ calculator.y + "=" 
				+ calculator.mod());
		
		scanner.close();
	}

}
