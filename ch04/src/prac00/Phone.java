package prac00;

public class Phone {
	private String name;
	private String tel;
	
	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
}

/*
 * Main 에서 실행하고, 값을 저장할 클래스, 기능을 만들 클래스가
 필요하다.  
 
 값저장 : 변수지정 -> 변수마다 값을 저장 할 메서드 
 기능 : ex) 전화번호저장 : 1. 인원수 2. 이름, 전화번호 3. 검색할이름
 4. 종료
 
 배열을 만들어 주고, instance 이용, 
 인원수를 저장할, 이름과 전화번호 입력, 이름과 전화번호 저장된 것을
 불려와서 출력 할(+출력을 안한다면 종료) 
 
 */
