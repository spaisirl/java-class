package ex05;

public class PhoneMain {

	public static void main(String[] args) {
		//PhoneInterface pi = new PhoneInterface();
		//인터페이스는 객체생성을 할 수가 없다.
		SmartPhone phone1 = new SmartPhone();
		phone1.sendCall();
		phone1.receiveCall();
		
		//인터페이스를 상위타입으로 지정 할 수 있다.
		PhoneInterface phone2 = new SmartPhone(); //실제 객체는 SmartPhone
		phone2.sendCall();
		phone2.receiveCall();
		//phone2.calculate(); // x
		
		CalcInterface phone3 = new SmartPhone();
		phone3.calculate();
		//phone3.sendCall(); // x
		//phoe3.receiveCall(); // x
		//CalInterface 클래스에 sendCall을 따로 만들지 않아 phone3로 사용불가.
	}

}
