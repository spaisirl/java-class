package ex01;

public class ForExample2 {
	
	//다시 풀어보기
	//1~100까지 홀수의 합, 짝수의 합, 전체의 합 구하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 0; // 
		int num2 = 0; // 
	
		for(int count = 1;count<=100;count++) {
			
			
			if(count %2 == 1) {
				num1+=count;
			}
			else {
				num2+=count;
			}
		}
		
		System.out.println("홀수의 합: " + num1);
		System.out.println("짝수의 합: " + num2);
		System.out.println("전체의 합: " + (num1 + num2));
		
	}

}
