package ex05;

public class SmartPhone implements PhoneInterface, CalcInterface {

	@Override
	public void sendCall() {
		// TODO Auto-generated method stub
		System.out.println("전화를 겁니다.");

	}

	@Override
	public void receiveCall() {
		// TODO Auto-generated method stub
		System.out.println("전화를 받습니다.");
	}

	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		System.out.println("계산을 합니다.");
	}

}
