package ex01;

public class ForExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for 조건 true 동안
		 * for(처음1번할꺼;)
		 * - 횟수를 예상 할 수 있을 때
		 *while 조건 true 동안
		 *- 예측을 할 수 없는 경우
		 *do {한다} =- while 조건 true 동안
		 *-예측을 할 수 없는 경우
		 *-최소 1회는 하고 싶은 경우
		 */
		for (int count = 1;count<=10;count++) { //count 변수
			System.out.println(count + " Hello");
		}
		
		// 1부터 10까지 누적 합계
		// 1+2+3+....+10 = ?
		int sum = 0;
		
		for(int count = 0;count<=10;count++) { 
			/*순서 int count -> count<=10 -> 
			(카운트횟수 조건일치 하면 수식실행) sum+=count -> count++
			*/
			sum += count; //sum = sum + 1;
		}
		//sum+=2; //sum = sum + 1;
		//sum+=3; //sum = sum + 1;
		System.out.println("합계: " + sum);
		System.out.println("프로그램 종료");
	}

}
