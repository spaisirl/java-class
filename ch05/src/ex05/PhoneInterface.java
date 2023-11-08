package ex05;

public interface PhoneInterface {
	public static final int TIMEOUT = 10000; //1초 (상수)
	//추상메서드
	public void sendCall();
	public void receiveCall();
	default void printLogt() {
		System.out.println("");
	}
}
