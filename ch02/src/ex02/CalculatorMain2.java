package ex02;

public class CalculatorMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체지향 프로그램
		Calculator2 cal = new Calculator2();
		cal.m = 10;
		cal.n = 5;
		System.out.println(cal.add());
		System.out.println(cal.sub());
		System.out.println(cal.mul());
		System.out.println(cal.div());
		System.out.println(cal.mod());

	}

}

class Calculator2 {
	
	// 데이터
	int m;
	int n;
	
	int add() {
		return m+n;
	}
	
	int sub() {
		return m-n;
	}
	
	int mul() {
		return m*n;
		
	}
	
	int div() {
		return m/n;
	}
	
	int mod() {
		return m%n;
	}
}