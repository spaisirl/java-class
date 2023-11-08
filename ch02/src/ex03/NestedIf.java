package ex03;

import java.util.Scanner;

public class NestedIf {

	public static void main(String[] args) {
		//스캐너 생성
		// Scanner: 데이터 타입, scanner: 참조변수
		Scanner scanner = new Scanner(System.in); // System.in: 키보드
		
		//점수: 출력
		System.out.print("점수:"); // System.out: 콘솔
		
		// 사용자로 부터 점수 입력 받기
		int score = scanner.nextInt();
		
		//학년: 출력
		System.out.print("학년:");
		int year = scanner.nextInt();
		
		//조건에 따라서 합격 불합격 출력
		if(60>=score) { //점수가 60이상이면 합격, 단 4학년이면 70이상 합격
			if(year == 4 && score>=70){
				System.out.println("합격입니다.");
			}
			else {
				System.out.println("불합격입니다.");
			}
		}
		else {
			System.out.println("합격");
		}
		
		//스캐너 닫기
		scanner.close();

	}

}
