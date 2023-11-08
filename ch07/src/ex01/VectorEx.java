package ex01;

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		//Vector - 목록형 컬렉션	
		// 순서가 있다. 중복 데이터 허용
	    Vector<Integer> vec1 = new Vector<>(); // 타입지정, 오른쪽 부분은 타입 생략 가능
	    
	    //기본 용량
	    int capa = vec1.capacity(); // capacity : 저장용량
	    System.out.println(capa);
	    
	    for (int i = 0; i <= capa; i++) {
	    	//벡터에 추가(맨뒤에 추가됨)
	    	vec1.add(i+1); 
	    }
	    
	    int size = vec1.size(); // 실제 데이터 크기 (몇개)
	    System.out.println("size: " + size); // 11
	    System.out.println(vec1.capacity()); // 20 , vector는 크기를 늘려야 할 때 현재 크기의 2배만큼 증가시킨다.
	    System.out.println("-----------------------");
	    
	    vec1.remove(0); //제거
	    vec1.add(2,1); //꺼내기 2번째에 1을 삽입
	    
	    for(int i =0; i<vec1.size(); i++) {
	    	System.out.println(vec1.get(i));
	    }
	    
	}
}
