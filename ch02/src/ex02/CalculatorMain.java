package ex02;



public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체지향 프로그램
		Calculator cal = new Calculator();
		int i = 10;
		int j = 5;
		
		System.out.println(cal.add(i, j));
		System.out.println(cal.sub(i, j));
		System.out.println(cal.mul(i, j));
		System.out.println(cal.div(i, j));
		System.out.println(cal.mod(i, j));
	}

}

class Calculator {
	
	int add(int m, int n) {
		return m+n;
	}
	
	int sub(int m, int n) {
		return m-n;
	}
	
	int mul(int m, int n) {
		return m*n;
		
	}
	
	int div(int m, int n) {
		return m/n;
	}
	
	int mod(int m, int n) {
		return m%n;
	}
}