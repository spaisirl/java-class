package ex01;

import java.util.Scanner;

//구조적 프로그래밍
public class ExamCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); // 객체를 만들 때 new 이용, 이 부분은 동작
		System.out.println("*** 간단계산기 ***");
		System.out.print("숫자1: ");
		int num1 = scanner.nextInt();
		System.out.print("숫자2: ");
		int num2 = scanner.nextInt();
		System.out.println("덧셈: " + num1 + "+" + num2 + "=" + add(num1, num2));
		System.out.println("빼기: " + num1 + "-" + num2 + "=" + sub(num1, num2));
		System.out.println("곱하기: " + num1 + "*" + num2 + "=" + mul(num1, num2));
		System.out.println("나누기: " + num1 + "/" + num2 + "=" + div(num1, num2));
		System.out.println("나머지: " + num1 + "%" + num2 + "=" + mod(num1, num2));
		scanner.close();
	}

	//더하기 : f(x,y) = x+y
	public static int add(int x, int y) {
		return x+y;
		
	}
	
	// 빼기
	public static int sub(int x, int y) {
		return x-y;
	}
	
	//곱하기
	
	public static int mul(int x, int y) {
		return x*y;
	}
	
	//나누기
	public static int div(int x, int y) {
		return x/y;
	}
	
	//나머지
	public static int mod(int x, int y) {
		return x%y;
	}
	
}
