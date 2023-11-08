package ex03;

public class DivideByZero {

	public static void main(String[] args) throws ArithmeticException{
		int num1 = 10;
		int num2 = 0;
		
		try {
			int result = num1/num2;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요.");
		} finally {			
			System.out.println("프로그램 종료");
		} //finally 생략 가능
		
		
	} //main
	
	public static int calculate(int n1, int n2) throws 
	ArithmeticException {
		return n1/n2;
	}
	
	

}
