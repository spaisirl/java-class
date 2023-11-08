package ex01;

public class TypeConersion {

	public static void main(String[] args) {
		// 컴파일러는 값을 확인하지 않고, 타입만 본다.
		// 자동 형변환
		// 자바의 연산(정수 int, 실수-double)
		int i = 300; //정수형 4바이트 (-21억~21억)
		long l = i; // 8바이트
		
		// 강제 형변환
		long l2 = 1000L;
		int i2 = (int)l2; //long -> int
		
		// 형변환은 같은 부류끼리만 가능
//		int i = (int)"3"; //에러
		double d = 3.14;
		int i3 = (int)d;
		System.out.println(i3);
		
		double d2 = 3.7;
		int i4 = (int)d2;
		System.out.println(i4); //3 반올림 하지 않는다.
		
		int kor = 75;
		int eng = 72;
		int math = 71;
		
		int total = kor+eng+math;
		System.out.println("total : " + total);
		double avg = (double)total/3; 
		// (double)(total/3) <-자주하는실수 이 경우 /부터 실행하여 double 형변환 x
		// double avg = total/3.0 해도 실수값 출력
		System.out.println("avg : " + avg);
		
	}

}
