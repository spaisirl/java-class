package ex05;

public class SingleObject {
	
	private static SingleObject instance; // instance 기본값 null
	
	private SingleObject() {/*singleton*/}
	
	public static SingleObject getInstance() { //private로 묶어져 있어서 static으로 불려준다.
		if (instance == null) {
			instance = new SingleObject(); // null 일 때 새로운 값을 만들어준다.
		}
		return instance;
	}
}
