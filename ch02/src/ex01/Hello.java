package ex01;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = sum(5, 10);
		System.out.println(value);
		String str = "Hello\njava"; // \n 줄바꿈
		System.out.println(str);
		str = "She said \"I Love you.\""; 
		System.out.println(str);
		str = "He said \"yes.\"";
		System.out.println(str);
		str = "G:\\workspace\\java\\ch02\\src\\ex01";
		System.out.println(str);
		final double Pi = 3.141592; //final을 쓰면 값을 고정하게 한다.
		double radius = 10;
		double area = Pi * radius * radius;  
		System.out.println("면적 : " + area);
		
	}
	public static int sum(int n, int m) {
		int result = n + m;
		return result; // 값을 sum으로 돌려준다.
	}
}
	
	/* 1. 의미있는 이름
	 * 2. 클래스의 이름은 대문자로 시작
	   3. 변수, 함수의 이름은 소문자로 시작
	   4. 숫자로 시작하면 안된다.
	   5. 특수문자는 _(언더스코어)만 쓴다.
	   6. 두개의 단어가 복합된 이름은 바뀌는 단어의 첫글자 대문자
	   
	 *기본타입 : 8개
	 * boolean : true false
	 * char
	 * byte~int 정수타입
	 * byte 1바이트 -128~127(8비트)
	 * short 2바이트
	 * int 4바이트
	 * long 8바이트
	 * float~double 실수타입
	 * float : 4바이트
	 * double : 8바이트
	 * String 클래스로 문자열 표현
	 * String toolName = "JDK";
	 * 
	 * 리터럴 : 프로그램에서 직접 표현한 값
	 * 정수, 실수, 문자, 논리, 문자열 리터럴 있음
	 * 정수 리터럴
	 * 15 - 10진수 15
	 * 015 0으로 시작하면 8진수. 십진수로 13 3자리 씩 묶기
	 * 0x15 16진수 십진수로 21. 4자리 씩 묶기
	 * 0b1111 2진수 십진수로 15.
	 * long 타입 리터럴은 숫자 뒤에 L또는 l을 붙여 표현
	 * 소수점 형태는 0.1234 = 1234E-4
	 * float 타입은 리터럴은 F 붙여 표현
	 */
