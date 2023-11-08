package ex03;

import java.util.Scanner;

//예제
public class Calculator { //같은 패키지 안에 객체명 같은 거 있을 시 오류 발생.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력한 연산자에 따른 결과를 출력");
		System.out.print("숫자1: ");
		int num1 = scanner.nextInt();
		System.out.print("숫자2: ");
		int num2 = scanner.nextInt();
		System.out.print("연산자: ");
		String operator = scanner.next();
		
		
		switch(operator) { //()안에는 하나의 객체만 들어갈 수 있다.
			case "+":
				System.out.print("덧셈결과: " + num1 + "+" + num2 + 
						"=" );
				System.out.println(num1 + num2);
				/*System.out.print("덧셈결과: " + num1 + "+" + num2 + 
			"=" + (num1 + num2)); = 뒤에 결과값은 괄호쳐야지 정수로 입력됨*/
				break;
			case "-":
				System.out.print("뺄셈결과: " + num1 + "-" + num2 + 
						"=");
				System.out.println(num1 - num2);
				break;
			case "*":
				System.out.print("곱셈결과: " + num1 + "*" + num2 + 
						"=");
				System.out.println(num1 * num2);
				break;
			case "/":
				System.out.print("나눗셈결과: " + num1 + "/" + num2 + 
						"=");
				System.out.println(num1 / num2);
				break;
			default:
			System.out.println("연산자를 넣고 다시 시도 해주세요.");
			
		}

		
		scanner.close();
		
	}
			
}
