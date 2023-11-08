package prac00;

public class PhoneMain {

	public static void main(String[] args) {
		PhoneManger manger = PhoneManger.getInstance();
		manger.setCount();
		manger.inputData();
		manger.search();
	}
}	
	

/* 
 * public - 공용의, 공동의 - 아무 클래스에서나 접근 가능
(default) - 같은 패키지의 클래스에서만 접근 가능
private - 개인적인, 사적인
static - 정적인, 고정된, 공유자원


StacticSample ss1 = new StaticSample();
StacticSample ss2 = new StaticSample();

ss1.n = 10
ss2.n = 20

이때는 ss1,ss2 실행 시 각각 10,20으로 나온다.

ss1.m = 100
ss2.m = 200

한 번 실행 후 다시 실행하면 둘 다 200으로 나온다.  
*/
 